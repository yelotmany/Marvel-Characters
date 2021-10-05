package com.yelotmany.marvelcharacters.features.model.entities

import android.os.Parcel
import android.os.Parcelable

data class MarvelCharacter constructor(
    var id: Int,
    var imageURL: String?,
    var name: String?,
    var description: String?
): Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(imageURL)
        parcel.writeString(name)
        parcel.writeString(description)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MarvelCharacter> {
        override fun createFromParcel(parcel: Parcel): MarvelCharacter {
            return MarvelCharacter(parcel)
        }

        override fun newArray(size: Int): Array<MarvelCharacter?> {
            return arrayOfNulls(size)
        }
    }
}
