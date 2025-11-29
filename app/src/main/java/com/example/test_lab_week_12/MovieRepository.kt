package com.example.test_lab_week_12

import com.example.test_lab_week_12.api.MovieService
import com.example.test_lab_week_12.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class MovieRepository(private val movieService: MovieService) {

    private val apiKey = "YOUR_API_KEY_HERE"

    // Return Flow<List<Movie>>
    fun fetchMovies(): Flow<List<Movie>> {
        return flow {
            val popularMovies = movieService.getPopularMovies(apiKey)
            emit(popularMovies.results)
        }.flowOn(Dispatchers.IO)
    }
}
