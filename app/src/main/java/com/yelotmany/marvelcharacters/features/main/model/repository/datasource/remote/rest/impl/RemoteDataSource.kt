package com.yelotmany.marvelcharacters.features.main.model.repository.datasource.remote.rest.impl

import androidx.lifecycle.MutableLiveData
import com.yelotmany.marvelcharacters.features.main.model.entities.MarvelCharacter
import com.yelotmany.marvelcharacters.features.main.model.repository.datasource.remote.RemoteDataSource
import com.yelotmany.marvelcharacters.features.main.model.repository.datasource.remote.rest.RetrofitBuilder
import com.yelotmany.marvelcharacters.features.main.model.repository.datasource.remote.rest.utils.RemoteDataMapper
import com.yelotmany.marvelcharacters.features.main.model.repository.datasource.remote.rest.utils.RequestResult
import javax.inject.Inject


class RemoteDataSourceImpl @Inject constructor(): RemoteDataSource {

    override var items: MutableLiveData<List<MarvelCharacter>?> = MutableLiveData<List<MarvelCharacter>?>()

    override suspend fun loadDataFromServer(): RequestResult {

        val apiService = RetrofitBuilder.API_SERVICE
        return try {
            val call = apiService.getCharacters()
            RequestResult.Success(
                result = RemoteDataMapper.mapListCharacterRestModelToCharacter(call.body()!!.data.results)
            )
        } catch (e: Exception) {
            RequestResult.Error(e)
        }
    }
}
