package com.example.kotlin_example_app.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import com.example.kotlin_example_app.data.model.product.ProductModel
import com.example.kotlin_example_app.data.remote.retrofit.ApiService
import retrofit2.Call
import retrofit2.Response


/**
 * Created by MN on 22,January,2024
 * Copyright (c): SIMEC System Ltd.
 */
class HomeViewModel : ViewModel() {


    private var productModelLiveData = MutableLiveData<ProductModel>();
    private var limitProductModelLiveDataModel = MutableLiveData<ProductModel>();


    fun getProducts() {

        ApiService.api.getPosts().enqueue(object : retrofit2.Callback<ProductModel> {
            override fun onFailure(call: Call<ProductModel>, t: Throwable) {
                Log.e("Retrofit Error", t.message.toString())
            }

            override fun onResponse(
                call: Call<ProductModel>,
                response: Response<ProductModel>
            ) {
                if (response.isSuccessful) {

                    if (response.body() != null) {
                        productModelLiveData.value = response.body();
                    }


                } else {


                }

            }

        });

    }

    fun getProductsLimit(limit: String) {

        ApiService.api.getPostsLimit(limit).enqueue(object : retrofit2.Callback<ProductModel> {
            override fun onFailure(call: Call<ProductModel>, t: Throwable) {
                Log.e("Retrofit Error", t.message.toString())
            }

            override fun onResponse(
                call: Call<ProductModel>,
                response: Response<ProductModel>
            ) {
                if (response.isSuccessful) {

                    if (response.body() != null) {
                        limitProductModelLiveDataModel.value = response.body();
                    }
                } else {
                }


            }
        });

    }

    fun observeProductModelLiveData(): LiveData<ProductModel> {
        return productModelLiveData;
    }


    fun observeLimitProductModelLiveData(): LiveData<ProductModel> {
        return limitProductModelLiveDataModel;
    }


}