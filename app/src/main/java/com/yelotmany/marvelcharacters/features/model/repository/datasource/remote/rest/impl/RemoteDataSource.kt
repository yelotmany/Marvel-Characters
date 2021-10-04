package com.yelotmany.marvelcharacters.features.model.repository.datasource.remote.rest.impl

import androidx.lifecycle.MutableLiveData
import com.yelotmany.marvelcharacters.features.model.entities.MarvelCharacter
import com.yelotmany.marvelcharacters.features.model.repository.datasource.remote.RemoteDataSource
import com.yelotmany.marvelcharacters.features.model.repository.datasource.remote.rest.ApiService
import com.yelotmany.marvelcharacters.features.model.repository.datasource.remote.rest.RetrofitBuilder
import com.yelotmany.marvelcharacters.features.model.repository.datasource.remote.rest.utils.RemoteDataMapper
import com.yelotmany.marvelcharacters.features.model.repository.datasource.remote.rest.utils.RequestResult
import javax.inject.Inject


class RemoteDataSourceImpl @Inject constructor(private val apiService: ApiService): RemoteDataSource {

    override var items: MutableLiveData<List<MarvelCharacter>?> = MutableLiveData<List<MarvelCharacter>?>()

    override suspend fun loadDataFromServer(): RequestResult {

        return try {
            val call = apiService.getCharacters()
            RequestResult.Success(
                result = RemoteDataMapper.mapListCharacterRestModelToCharacter(call.body()?.data?.results)
            )
        } catch (e: Exception) {
            RequestResult.Error(e)
        }
    }
}
