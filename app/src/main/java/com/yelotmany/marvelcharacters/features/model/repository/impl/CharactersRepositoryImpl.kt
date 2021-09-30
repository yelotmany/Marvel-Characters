package com.yelotmany.marvelcharacters.features.model.repository.impl

import androidx.lifecycle.MutableLiveData
import com.yelotmany.marvelcharacters.features.model.entities.MarvelCharacter
import com.yelotmany.marvelcharacters.features.model.repository.CharactersRepository
import com.yelotmany.marvelcharacters.features.model.repository.datasource.CharactersDataSource
import javax.inject.Inject

class CharactersRepositoryImpl @Inject constructor(private val dataSource: CharactersDataSource):
    CharactersRepository {

    override fun loadMarvelCharactersList(): List<MarvelCharacter> {

        return dataSource.loadMockCharactersList().value!!
    }
}