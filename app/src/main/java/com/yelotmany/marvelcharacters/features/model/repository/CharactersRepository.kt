package com.yelotmany.marvelcharacters.features.model.repository

import androidx.lifecycle.MutableLiveData
import com.yelotmany.marvelcharacters.features.model.entities.MarvelCharacter

interface CharactersRepository {

    fun loadMarvelCharactersList(): MutableLiveData<List<MarvelCharacter>?>
}
