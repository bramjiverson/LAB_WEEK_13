package com.example.test_lab_week_13

import android.app.Application
import com.example.test_lab_week_13.api.MovieService
import com.example.test_lab_week_13.database.MovieDatabase

class MovieApplication : Application() {

    companion object {
        lateinit var movieService: MovieService
        lateinit var movieRepository: MovieRepository
    }

    override fun onCreate() {
        super.onCreate()

        movieService = MovieService.create()

        val movieDatabase = MovieDatabase.getInstance(applicationContext)

        movieRepository = MovieRepository(
            movieService,
            movieDatabase
        )
    }
}
