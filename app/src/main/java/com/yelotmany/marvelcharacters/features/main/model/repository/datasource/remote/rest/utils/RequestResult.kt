package com.yelotmany.marvelcharacters.features.main.model.repository.datasource.remote.rest.utils

import com.yelotmany.marvelcharacters.features.main.model.entities.MarvelCharacter

sealed class RequestResult{

    object Loading : RequestResult()
    class Success(val result: List<MarvelCharacter>?): RequestResult()
    class Error(val e: Exception): RequestResult()
}
