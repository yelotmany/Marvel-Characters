package com.yelotmany.marvelcharacters.features.main.model.repository.datasource.remote

import androidx.lifecycle.MutableLiveData
import com.yelotmany.marvelcharacters.features.main.model.entities.MarvelCharacter
import com.yelotmany.marvelcharacters.features.main.model.repository.datasource.remote.rest.utils.RequestResult

interface RemoteDataSource {

    var items: MutableLiveData<List<MarvelCharacter>?>

    suspend fun loadDataFromServer(): RequestResult
}
