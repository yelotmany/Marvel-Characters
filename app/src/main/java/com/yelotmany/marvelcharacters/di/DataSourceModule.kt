package com.yelotmany.marvelcharacters.di

import com.yelotmany.marvelcharacters.features.model.repository.datasource.remote.RemoteDataSource
import com.yelotmany.marvelcharacters.features.model.repository.datasource.remote.rest.ApiService
import com.yelotmany.marvelcharacters.features.model.repository.datasource.remote.rest.impl.RemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataSourceModule {

    @Singleton
    @Provides
    fun provideRemoteDataSource(apiService: ApiService): RemoteDataSource{
        return RemoteDataSourceImpl(apiService)
    }
}
