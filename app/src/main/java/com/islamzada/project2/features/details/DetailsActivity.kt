package com.islamzada.project2.features.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
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

        viewModel = ViewModelProvider(this)[DetailsViewModel::class.java]


        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        setContentView(binding.root)

        val name = intent.getStringExtra("name")
        val code = intent.getIntExtra("code", 0).toString()
        val desc = intent.getStringExtra("desc")

        viewModel.name.value = "Product name: $name"
        viewModel.code.value = "Product code: $code"
        viewModel.desc.value = "Product description: $desc"
    }
}