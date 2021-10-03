package com.yelotmany.marvelcharacters.features.model.repository.datasource.remote.rest.impl

import androidx.lifecycle.MutableLiveData
import com.yelotmany.marvelcharacters.features.model.entities.MarvelCharacter
import com.yelotmany.marvelcharacters.features.model.repository.datasource.remote.RemoteDataSource
import com.yelotmany.marvelcharacters.features.model.repository.datasource.remote.rest.RetrofitBuilder
import com.yelotmany.marvelcharacters.features.model.repository.datasource.remote.rest.utils.RemoteDataMapper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RemoteDataSourceImpl: RemoteDataSource {

    override var items: MutableLiveData<List<MarvelCharacter>?> = MutableLiveData<List<MarvelCharacter>?>()

    override fun loadDataFromServer() {

        CoroutineScope(Dispatchers.IO).launch {
            val call = RetrofitBuilder.API_SERVICE.getCharacters()

            val result =
                if (call.isSuccessful)
                    RemoteDataMapper.mapListCharacterRestModelToCharacter(call.body()?.data?.results)
                else
                    ArrayList()

            items.postValue(result)
        }
    }
}
