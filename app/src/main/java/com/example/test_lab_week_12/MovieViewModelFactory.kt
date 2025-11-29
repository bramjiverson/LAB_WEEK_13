package com.example.test_lab_week_12

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.test_lab_week_12.api.MovieService

class MovieViewModelFactory(private val movieService: MovieService) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MovieViewModel(movieService) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
