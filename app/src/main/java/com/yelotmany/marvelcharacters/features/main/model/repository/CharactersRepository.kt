package com.yelotmany.marvelcharacters.features.main.model.repository

import com.yelotmany.marvelcharacters.features.main.model.repository.datasource.remote.rest.utils.RequestResult

interface CharactersRepository {

    suspend fun loadMarvelCharactersList(): RequestResult
}
