package com.yelotmany.marvelcharacters.features.model.repository.datasource.remote

import androidx.lifecycle.MutableLiveData
import com.yelotmany.marvelcharacters.features.model.entities.MarvelCharacter

interface RemoteDataSource {

    var items: MutableLiveData<List<MarvelCharacter>?>

    fun loadDataFromServer()
}
