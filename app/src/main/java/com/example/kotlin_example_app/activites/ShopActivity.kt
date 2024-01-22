package com.example.kotlin_example_app.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.kotlin_example_app.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class ShopActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)
        val bottomNavigationItemView = findViewById<BottomNavigationView>(R.id.id_bottom_app_bar)
        val navController = Navigation.findNavController(this, R.id.id_fragment_container_view)
        NavigationUI.setupWithNavController(bottomNavigationItemView, navController)

    }
}