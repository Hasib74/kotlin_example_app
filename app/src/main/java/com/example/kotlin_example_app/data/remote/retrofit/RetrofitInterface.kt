package com.example.kotlin_example_app.data.remote.retrofit

import com.example.kotlin_example_app.data.model.product.ProductModel
import com.example.kotlin_example_app.data.remote.urls.ApiUrls
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Created by MN on 22,January,2024
 * Copyright (c): SIMEC System Ltd.
 */
interface RetrofitInterface {

    @GET(ApiUrls.GET_PRODUCT)
    fun getPosts(): Call<ProductModel>;

    @GET(ApiUrls.GET_PRODUCT)
    fun getPostsLimit(@Query("limit") limit: String): Call<ProductModel>;


}