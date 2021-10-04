package com.yelotmany.marvelcharacters.features.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yelotmany.marvelcharacters.features.model.entities.MarvelCharacter
import com.yelotmany.marvelcharacters.features.model.repository.CharactersRepository
import com.yelotmany.marvelcharacters.features.model.repository.datasource.remote.rest.utils.RequestResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class CharactersListViewModel @Inject constructor(val charactersRepository: CharactersRepository):
    ViewModel(){

    lateinit var items: MutableLiveData<RequestResult>

    fun loadCharactersList(){

        items = MutableLiveData()

        items.postValue(RequestResult.Loading)
        viewModelScope.launch(Dispatchers.IO){
            items.postValue(charactersRepository.loadMarvelCharactersList())
        }
    }


    fun openCharacterDetails(character: MarvelCharacter){
        //open character details
    }
}
