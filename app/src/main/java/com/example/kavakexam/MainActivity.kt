package com.example.kavakexam

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.kavakexam.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setSupportActionBar(findViewById(R.id.toolbar))

        val navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)


        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            showToolbar(destination)
        }

    }

    private fun showToolbar(destination: NavDestination) {

        binding.toolbar.visibility =
        if (destination.id!= R.id.gnomeDetailFragment) {
            View.VISIBLE
        } else {
            View.GONE
        }

    }

}