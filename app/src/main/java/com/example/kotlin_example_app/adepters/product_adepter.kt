package com.example.kotlin_example_app.adepters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlin_example_app.data.model.product.ProductModel
import com.example.kotlin_example_app.databinding.ProductCardBinding


/**
 * Created by MN on 30,January,2024
 * Copyright (c): SIMEC System Ltd.
 */
class ProductAdepter : RecyclerView.Adapter<ProductAdepter.ProductViewHolder>() {

    private var productModelList = ProductModel();

    fun setProductModelList(productModelList: ProductModel) {
        this.productModelList = productModelList;
        notifyDataSetChanged();
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {


        return ProductViewHolder(
            ProductCardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        );


    }


    override fun getItemCount(): Int {

        return productModelList.size;
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {


        println("holder width: " + holder.itemView.rootView.width);


        // holder.itemView.layoutParams.width = 200;

        Glide.with(holder.itemView.context)
            .load(productModelList.get(position).image)
            .into(holder.binding.ivProductImage);

        holder.binding.tvProductName.setText(productModelList.get(position).title);
        holder.binding.tvProductName.textAlignment = ViewGroup.TEXT_ALIGNMENT_CENTER;

        holder.binding.tvProductPrice.setText(productModelList.get(position).price.toString());


    }


    class ProductViewHolder(val binding: ProductCardBinding) :
        RecyclerView.ViewHolder(binding.root)
}