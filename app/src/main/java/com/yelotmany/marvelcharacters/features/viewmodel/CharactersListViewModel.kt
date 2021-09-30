package com.yelotmany.marvelcharacters.features.viewmodel

import androidx.lifecycle.ViewModel
import com.yelotmany.marvelcharacters.features.model.entities.MarvelCharacter
import com.yelotmany.marvelcharacters.features.model.repository.CharactersRepository
import javax.inject.Inject

class CharactersListViewModel @Inject constructor(val charactersRepository: CharactersRepository):
    ViewModel() {

    lateinit var items: List<MarvelCharacter>

    fun loadCharactersList(){
        items = charactersRepository.loadMarvelCharactersList()
    }

    fun openCharacterDetails(character: MarvelCharacter){
        //open character details
    }
}

