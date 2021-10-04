package com.yelotmany.marvelcharacters.features.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yelotmany.marvelcharacters.features.model.entities.MarvelCharacter
import com.yelotmany.marvelcharacters.features.model.repository.CharactersRepository
import com.yelotmany.marvelcharacters.features.model.repository.datasource.remote.rest.utils.RequestResult
import com.yelotmany.marvelcharacters.features.view.utils.Event
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class CharactersListViewModel @Inject constructor(val charactersRepository: CharactersRepository):
    ViewModel(){

    lateinit var items: MutableLiveData<RequestResult>

    private val _openCharacterEvent = MutableLiveData<Event<MarvelCharacter>>()
    val openCharacterEvent: LiveData<Event<MarvelCharacter>> = _openCharacterEvent

    fun loadCharactersList(){

        if (this::items.isInitialized)
            return

        items = MutableLiveData()

        items.postValue(RequestResult.Loading)
        viewModelScope.launch(Dispatchers.IO){
            items.postValue(charactersRepository.loadMarvelCharactersList())
        }
    }


    fun openCharacterDetails(character: MarvelCharacter){

        _openCharacterEvent.value = Event(character)
    }
}
