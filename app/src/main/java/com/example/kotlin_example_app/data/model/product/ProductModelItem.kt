package com.example.kotlin_example_app.data.model.product
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName



@Entity(tableName = "productTable")
data class ProductModelItem(
    @SerializedName("category")
    val category: String?,
    @SerializedName("description")
    val description: String?,
    @PrimaryKey
    @SerializedName("id")
    val id: Int?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("price")
    val price: Double?,
    @SerializedName("rating")
    val rating: Rating?,
    @SerializedName("title")
    val title: String?
)