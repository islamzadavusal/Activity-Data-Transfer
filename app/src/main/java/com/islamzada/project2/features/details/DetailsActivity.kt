package com.islamzada.project2.features.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.islamzada.project2.R
import com.islamzada.project2.databinding.ActivityAddProductBinding
import com.islamzada.project2.databinding.ActivityDetailsBinding
import com.islamzada.project2.databinding.ActivityMainBinding

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding
    private lateinit var viewModel: DetailsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailsBinding.inflate(layoutInflater)


        binding = ActivityDetailsBinding.inflate(layoutInflater)


        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        setContentView(binding.root)
    }
}