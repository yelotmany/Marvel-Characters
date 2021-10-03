package com.yelotmany.marvelcharacters.features.viewmodel

import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.yelotmany.marvelcharacters.features.model.entities.MarvelCharacter
import com.yelotmany.marvelcharacters.features.model.repository.CharactersRepository
import javax.inject.Inject

class CharactersListViewModel @Inject constructor(val charactersRepository: CharactersRepository):
    ViewModel(){

    lateinit var items: MutableLiveData<List<MarvelCharacter>?>

    lateinit var isLoading: MutableLiveData<Boolean>

    var showMessageError = false

    private val changeObserver = Observer<List<MarvelCharacter>?> { newValue ->
        if (newValue.isNotEmpty())
            isLoading.postValue(false)
        else
            showMessageError = true

    }

    fun loadCharactersList(){
        isLoading = MutableLiveData()
        isLoading.postValue(true)
        items = charactersRepository.loadMarvelCharactersList()
        items.observeForever(changeObserver)
    }


    fun openCharacterDetails(character: MarvelCharacter){
        //open character details
    }
}
