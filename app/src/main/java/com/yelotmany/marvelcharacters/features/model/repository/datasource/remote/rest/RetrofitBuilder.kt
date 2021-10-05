package com.yelotmany.marvelcharacters.features.model.repository.datasource.remote.rest

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private const val BASE_URL = "https://gateway.marvel.com"

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val API_SERVICE: ApiService = getRetrofit().create(ApiService::class.java)
}
