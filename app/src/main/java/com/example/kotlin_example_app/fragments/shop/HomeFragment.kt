package com.example.kotlin_example_app.fragments.shop

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide

import com.example.kotlin_example_app.R
import com.example.kotlin_example_app.data.model.product.ProductModel
import com.example.kotlin_example_app.data.remote.retrofit.ApiService
import com.example.kotlin_example_app.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomeFragment : Fragment() {

    // private var binding = FragmentHomeBinding.inflate(layoutInflater)

    private lateinit var binding: FragmentHomeBinding;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ApiService.api.getPosts().enqueue(object : retrofit2.Callback<ProductModel> {
            override fun onFailure(call: Call<ProductModel>, t: Throwable) {
                Log.e("Retrofit Error", t.message.toString())
            }

            override fun onResponse(
                call: Call<ProductModel>,
                response: Response<ProductModel>
            ) {
                if (response.isSuccessful) {
                    Log.e("Retrofit Response", response.body().toString())
                    Glide.with(this@HomeFragment).load(response.body()?.get(0)?.image)
                        .into(binding.idIvBanner)
                } else
                    Log.e("Retrofit Response", response.errorBody().toString())
            }

        })
    }


}