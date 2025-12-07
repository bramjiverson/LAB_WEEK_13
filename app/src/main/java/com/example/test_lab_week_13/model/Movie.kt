package com.example.test_lab_week_13.model

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

@Entity(tableName = "movies")
data class Movie(
    @PrimaryKey val id: Int,
    val title: String? = "",
    val overview: String? = "",
    val poster_path: String? = "",
    val backdrop_path: String? = ""   // ⬅ WAJIB default biar tidak NOT NULL error
)