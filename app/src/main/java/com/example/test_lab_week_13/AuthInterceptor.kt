package com.example.test_lab_week_13

import com.example.test_lab_week_13.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()

        // Wajib pakai .url()
        val url = request.url()
            .newBuilder()
            .addQueryParameter("api_key", BuildConfig.TMDB_API_KEY)
            .build()

        request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}
