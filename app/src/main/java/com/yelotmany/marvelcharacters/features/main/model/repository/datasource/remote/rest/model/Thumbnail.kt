package com.yelotmany.marvelcharacters.features.main.model.repository.datasource.remote.rest.model

import com.google.gson.annotations.SerializedName

data class Thumbnail(
    @SerializedName("path")
    var path: String,

    @SerializedName("extension")
    var extension: String
){
    fun getUrl() = "$path.$extension".replace("http", "https")
}
