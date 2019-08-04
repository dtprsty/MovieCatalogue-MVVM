package com.prsty.moviecatalogue.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieEntity (
    var movieName: String?,
    var releaseDate: String?,
    var rating: String?,
    var voter: Int?,
    var description: String?,
    var imgPoster: Int?
) : Parcelable