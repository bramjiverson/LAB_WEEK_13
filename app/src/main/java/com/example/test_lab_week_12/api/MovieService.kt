package com.example.test_lab_week_12.api

import com.example.test_lab_week_12.model.PopularMoviesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("def1e691d83bdeb5e7a808758e56275c") apiKey: String
    ): PopularMoviesResponse
}
