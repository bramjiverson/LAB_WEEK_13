package com.example.test_lab_week_12

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test_lab_week_12.api.MovieService
import com.example.test_lab_week_12.model.Movie
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

// --- PERBAIKAN: Hapus nilai default dari konstruktor ---
// Sekarang, kelas ini tidak lagi bergantung pada MovieApplication secara langsung.
class MovieViewModel(private val movieService: MovieService) : ViewModel() {

    // Bagian ini sudah benar dan tidak perlu diubah.
    private val _movies = MutableStateFlow<List<Movie>?>(null)
    val movies: StateFlow<List<Movie>?> = _movies

    init {
        fetchPopularMovies()
    }

    private fun fetchPopularMovies() {
        viewModelScope.launch {
            try {
                val response = movieService.getPopularMovies()
                if (response.isSuccessful) {
                    _movies.value = response.body()?.results
                } else {
                    // Handle error
                }
            } catch (e: Exception) {
                // Handle exception
            }
        }
    }
}
