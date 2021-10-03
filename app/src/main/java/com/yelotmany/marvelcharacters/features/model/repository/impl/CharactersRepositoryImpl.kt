package com.yelotmany.marvelcharacters.features.model.repository.impl

import androidx.lifecycle.MutableLiveData
import com.yelotmany.marvelcharacters.features.model.entities.MarvelCharacter
import com.yelotmany.marvelcharacters.features.model.repository.CharactersRepository
import com.yelotmany.marvelcharacters.features.model.repository.datasource.remote.RemoteDataSource
import javax.inject.Inject

class CharactersRepositoryImpl @Inject constructor( private val remoteDataSource: RemoteDataSource):
    CharactersRepository {

    override fun loadMarvelCharactersList(): MutableLiveData<List<MarvelCharacter>?> {

        remoteDataSource.loadDataFromServer()
        return remoteDataSource.items
    }
}
