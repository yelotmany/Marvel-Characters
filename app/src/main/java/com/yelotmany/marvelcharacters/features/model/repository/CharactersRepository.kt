package com.yelotmany.marvelcharacters.features.model.repository

import com.yelotmany.marvelcharacters.features.model.repository.datasource.remote.rest.utils.RequestResult

interface CharactersRepository {

    suspend fun loadMarvelCharactersList(): RequestResult
}
