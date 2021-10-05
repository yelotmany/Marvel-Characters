package com.yelotmany.marvelcharacters.features.model.repository.datasource.remote.rest

import com.yelotmany.marvelcharacters.features.model.repository.datasource.remote.rest.model.CharacterRestModel
import com.yelotmany.marvelcharacters.features.model.repository.datasource.remote.rest.model.MarvelApiResponse
import com.yelotmany.marvelcharacters.features.model.repository.datasource.remote.rest.utils.MarvelApiConstants.MARVEL_API_HASH
import com.yelotmany.marvelcharacters.features.model.repository.datasource.remote.rest.utils.MarvelApiConstants.MARVEL_API_PUBLIC_KEY
import com.yelotmany.marvelcharacters.features.model.repository.datasource.remote.rest.utils.MarvelApiConstants.MARVEL_API_TS
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/v1/public/characters?apikey=$MARVEL_API_PUBLIC_KEY&ts=$MARVEL_API_TS&hash=$MARVEL_API_HASH")
    suspend fun getCharacters(): Response<MarvelApiResponse<CharacterRestModel>>
}
