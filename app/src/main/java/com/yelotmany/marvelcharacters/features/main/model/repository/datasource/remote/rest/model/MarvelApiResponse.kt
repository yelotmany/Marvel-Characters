package com.yelotmany.marvelcharacters.features.main.model.repository.datasource.remote.rest.model

import com.google.gson.annotations.SerializedName

data class MarvelApiResponse<T>(
    @SerializedName("code")
    val code: Int,

    @SerializedName("data")
    val data: MarvelApiData<T>,

    @SerializedName("status")
    val status: String
)
