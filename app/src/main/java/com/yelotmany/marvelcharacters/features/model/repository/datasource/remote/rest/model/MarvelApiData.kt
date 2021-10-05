package com.yelotmany.marvelcharacters.features.model.repository.datasource.remote.rest.model

import com.google.gson.annotations.SerializedName

data class MarvelApiData<T>(
    @SerializedName("offset")
    val offset: Int,

    @SerializedName("limit")
    val limit: Int,

    @SerializedName("total")
    val total: Int,

    @SerializedName("count")
    val count: Int,

    @SerializedName("results")
    var results: List<T>
)
