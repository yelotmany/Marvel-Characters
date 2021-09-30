package com.yelotmany.marvelcharacters.features.model.repository.datasource

import androidx.lifecycle.MutableLiveData
import com.yelotmany.marvelcharacters.features.model.entities.MarvelCharacter

interface CharactersDataSource {

    fun loadMockCharactersList(): MutableLiveData<List<MarvelCharacter>>
}