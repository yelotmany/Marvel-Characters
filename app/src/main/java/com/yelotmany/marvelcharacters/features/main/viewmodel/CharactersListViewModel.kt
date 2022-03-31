package com.yelotmany.marvelcharacters.features.main.viewmodel

import androidx.lifecycle.*
import com.yelotmany.marvelcharacters.features.main.model.entities.MarvelCharacter
import com.yelotmany.marvelcharacters.features.main.model.repository.CharactersRepository
import com.yelotmany.marvelcharacters.features.main.model.repository.datasource.remote.rest.utils.RequestResult
import com.yelotmany.marvelcharacters.features.main.view.utils.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersListViewModel @Inject constructor(private val charactersRepository: CharactersRepository):
    ViewModel(){

    lateinit var currentItems: MutableLiveData<RequestResult>
    private lateinit var items: RequestResult.Success

    private val _openCharacterEvent = MutableLiveData<Event<MarvelCharacter>>()
    val openCharacterEvent: LiveData<Event<MarvelCharacter>> = _openCharacterEvent

    fun loadCharactersList(){

        if (this::currentItems.isInitialized)
            return

        currentItems = MutableLiveData()

        currentItems.postValue(RequestResult.Loading)
        viewModelScope.launch(Dispatchers.IO){
            currentItems.postValue(charactersRepository.loadMarvelCharactersList())
        }

        currentItems.observeForever { result ->
            if (result is RequestResult.Success && !this::items.isInitialized)
                items = currentItems.value as RequestResult.Success
        }
    }


    fun openCharacterDetails(character: MarvelCharacter){

        _openCharacterEvent.value = Event(character)
    }

    fun filterList(text: String) {

        if (currentItems.value !is RequestResult.Success)
            return

        val filterResult = RequestResult.Success(items.result?.filter { it -> it.name!!.lowercase().contains(text.lowercase())})
        currentItems.postValue(filterResult)
    }
}
