package com.example.test_lab_week_12

import android.app.Application
import com.example.test_lab_week_12.api.AuthInterceptor
import com.example.test_lab_week_12.api.MovieService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MovieApplication : Application() {

    companion object {
        lateinit var movieService: MovieService
            private set
    }

    override fun onCreate() {
        super.onCreate()

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(AuthInterceptor())
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        movieService = retrofit.create(MovieService::class.java)
    }
}
