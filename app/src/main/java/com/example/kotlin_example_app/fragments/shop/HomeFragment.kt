package com.example.kotlin_example_app.fragments.shop

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide

import com.example.kotlin_example_app.R
import com.example.kotlin_example_app.activites.ProductDetailsActivity
import com.example.kotlin_example_app.adepters.ProductAdepter
import com.example.kotlin_example_app.data.model.product.ProductModel
import com.example.kotlin_example_app.data.model.product.ProductModelItem
import com.example.kotlin_example_app.data.remote.retrofit.ApiService
import com.example.kotlin_example_app.databinding.FragmentHomeBinding
import com.example.kotlin_example_app.viewmodel.HomeViewModel
import retrofit2.Call
import retrofit2.Response
import kotlin.random.Random
import kotlin.random.nextInt

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


    private lateinit var homeViewModel: HomeViewModel;

    private lateinit var product: ProductModelItem;

    private lateinit var productAdepter: ProductAdepter;

    companion object {

        var PRODUCT_ID = "product_id";
        var PRODUCT_NAME = "product_name";
        var PRODUCT_IMAGE = "product_image";
        var PRODUCT_PRICE = "product_price";
        var PRODUCT_RATING = "product_rating";
        var PRODUCT_DESCRIPTION = "product_description";


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        homeViewModel = ViewModelProvider(this)[HomeViewModel::class.java];

        productAdepter = ProductAdepter();

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

        productRecycularView();
        homeViewModel.getProducts();
        homeViewModel.getProductsLimit("10");
        observeProductModelLiveData();
        observeLimitedProductModelLiveData();
        bannerItemClickAndRedirectToProductDetailsActivity();


    }

    private fun observeLimitedProductModelLiveData() {
        homeViewModel.observeLimitProductModelLiveData().observe(viewLifecycleOwner) { data ->
            Log.e("ProductModel limit ", data.toString())


            productAdepter.setProductModelList(data);


        };
    }

    private fun productRecycularView() {
        binding.idRvCategory.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
            adapter = productAdepter;
        }

    }

    private fun bannerItemClickAndRedirectToProductDetailsActivity() {
        binding.idIvBanner.setOnClickListener { view ->
            val intent: Intent = Intent(requireContext(), ProductDetailsActivity::class.java);

            intent.putExtra(PRODUCT_ID, product.id)
            intent.putExtra(PRODUCT_NAME, product.title)
            intent.putExtra(PRODUCT_IMAGE, product.image)
            intent.putExtra(PRODUCT_PRICE, product.price)
            intent.putExtra(PRODUCT_RATING, product.rating?.rate)
            intent.putExtra(PRODUCT_DESCRIPTION, product.description)


            startActivity(intent)
        }


    }

    private fun observeProductModelLiveData() {
        homeViewModel.observeProductModelLiveData().observe(viewLifecycleOwner) { data ->
            Log.e("ProductModel", data.toString())

            val randomIntInRange =
                Random(data.size)// Generates a random integer between 0 (inclusive) and 100 (exclusive)

            Log.d("Random ---> ", Random.nextInt(0, data.size - 1).toString())

            val product = data[Random.nextInt(0, data.size - 1)];

            this.product = product;


            binding.idIvBanner.let {
                Glide.with(requireContext()).load(product.image).into(binding.idIvBanner)
            }
        };


    }


}