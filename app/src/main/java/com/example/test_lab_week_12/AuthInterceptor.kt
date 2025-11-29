package com.example.test_lab_week_12.api

import com.example.test_lab_week_12.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()

        // --- INI SOLUSINYA: Ganti .url menjadi .url() ---
        val url = request.url() // Panggil metode url()
            .newBuilder()
            .addQueryParameter("def1e691d83bdeb5e7a808758e56275c", BuildConfig.TMDB_API_KEY)
            .build()

        request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}
