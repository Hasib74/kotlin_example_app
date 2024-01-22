package com.example.kotlin_example_app.data.remote.retrofit

import com.example.kotlin_example_app.data.remote.urls.ApiUrls
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Created by MN on 22,January,2024
 * Copyright (c): SIMEC System Ltd.
 */
object ApiService {
    val api: RetrofitInterface by lazy {
        Retrofit.Builder().baseUrl(ApiUrls.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(RetrofitInterface::class.java);
    }
}