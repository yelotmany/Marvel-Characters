package com.yelotmany.marvelcharacters.features.main.model.repository.datasource.remote.rest.utils

object MarvelApiConstants {

    const val MARVEL_API_PUBLIC_KEY = "42bffa648ffc89a14a690eeef1981370"
    const val MARVEL_API_TS = 1
    const val MARVEL_API_HASH = "9bd5e9917a4e1b5847a5557f79f33696" // md5 (concatenate ts + private key + public key)
}
