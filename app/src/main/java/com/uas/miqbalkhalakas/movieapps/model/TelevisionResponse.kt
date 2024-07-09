package com.uas.miqbalkhalakas.movieapps

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TelevisionResponse(
    @SerializedName("results")
    val tv : List<Television>

) : Parcelable {
    constructor() : this(mutableListOf())
}
