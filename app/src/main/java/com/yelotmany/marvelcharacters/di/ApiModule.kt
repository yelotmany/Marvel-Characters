package com.yelotmany.marvelcharacters.di

import com.yelotmany.marvelcharacters.features.model.repository.datasource.remote.rest.ApiService
import com.yelotmany.marvelcharacters.features.model.repository.datasource.remote.rest.RetrofitBuilder
import dagger.Module
import dagger.Provides

@Module
class ApiModule {

    @Provides
    fun providesMarvelApi(): ApiService {
        return RetrofitBuilder.API_SERVICE
    }
}