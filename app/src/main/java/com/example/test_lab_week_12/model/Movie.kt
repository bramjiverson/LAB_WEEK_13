package com.example.test_lab_week_12.model

import com.squareup.moshi.Json

data class Movie(
    val id: Int,

    val title: String?,

    val overview: String?,

    @Json(name = "poster_path")
    val posterPath: String?,

    @Json(name = "release_date")
    val releaseDate: String?,

    val popularity: Double?
)
