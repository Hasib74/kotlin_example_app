package com.example.kotlin_example_app.data.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.kotlin_example_app.data.model.product.ProductModel


/**
 * Created by MN on 30,January,2024
 * Copyright (c): SIMEC System Ltd.
 */

@Dao
interface ProductDao {

    @Insert
    suspend fun insertProduct(product: ProductModel)

    @Query("SELECT * FROM productTable")
    suspend fun getAllProducts(): LiveData<ProductModel>

}