package com.yelotmany.marvelcharacters.features.main.model.repository.impl

import com.yelotmany.marvelcharacters.features.main.model.repository.CharactersRepository
import com.yelotmany.marvelcharacters.features.main.model.repository.datasource.remote.RemoteDataSource
import com.yelotmany.marvelcharacters.features.main.model.repository.datasource.remote.rest.utils.RequestResult
import javax.inject.Inject

class CharactersRepositoryImpl @Inject constructor(private val remoteDataSource: RemoteDataSource):
    CharactersRepository {

    override suspend fun loadMarvelCharactersList(): RequestResult {

        return remoteDataSource.loadDataFromServer()
    }
}
