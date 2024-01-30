package com.example.kotlin_example_app.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.example.kotlin_example_app.R
import com.example.kotlin_example_app.databinding.ActivityProductDetailsBinding
import com.example.kotlin_example_app.fragments.shop.HomeFragment

class ProductDetailsActivity : AppCompatActivity() {


    private lateinit var productId: String;
    private lateinit var productName: String;
    private lateinit var productImage: String;
    private lateinit var productPrice: String;
    private lateinit var productRating: String;
    private lateinit var productDescription: String;


    private lateinit var binding: ActivityProductDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //   setContentView(R.layout.activity_product_details)
        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        readDataFromIntent()
        setDataToView()


    }

    private fun setDataToView() {

        Glide.with(this).load(productImage).into(binding.headerImage)
        binding.headerImage.scaleType = android.widget.ImageView.ScaleType.CENTER_CROP
        binding.tvDetails.text = productDescription
        binding.tvTitle.text = productName



    }

    private fun readDataFromIntent() {
        productId = intent.getStringExtra(HomeFragment.PRODUCT_ID) ?: "0"
        productName =
            intent.getStringExtra(HomeFragment.PRODUCT_NAME) ?: "Welcome to Product Details";
        productImage = intent.getStringExtra(HomeFragment.PRODUCT_IMAGE) ?: "";

        Log.d("ProductDetailsActivity", "product image: $productImage")



        productPrice = intent.getStringExtra(HomeFragment.PRODUCT_PRICE) ?: "0.0";
        productRating = intent.getStringExtra(HomeFragment.PRODUCT_RATING) ?: "0.0";
        productDescription = intent.getStringExtra(HomeFragment.PRODUCT_DESCRIPTION) ?: "";
    }
}