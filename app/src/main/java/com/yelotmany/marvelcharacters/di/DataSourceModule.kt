package com.yelotmany.marvelcharacters.di

import com.yelotmany.marvelcharacters.features.main.model.repository.datasource.remote.RemoteDataSource
import com.yelotmany.marvelcharacters.features.main.model.repository.datasource.remote.rest.impl.RemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun provideRemoteDataSource(remoteDataSource: RemoteDataSourceImpl): RemoteDataSource
}
