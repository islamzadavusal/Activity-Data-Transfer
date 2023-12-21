package com.islamzada.project2.features.newproduct

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.ViewModelProvider
import com.islamzada.project2.R
import com.islamzada.project2.databinding.ActivityAddProductBinding
import com.islamzada.project2.databinding.ActivityMainBinding
import com.islamzada.project2.features.model.Product
import com.islamzada.project2.features.productlist.MainViewModel

class AddProductActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddProductBinding
    lateinit var viewModel: AddPostViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddProductBinding.inflate(layoutInflater)

        viewModel = ViewModelProvider(this)[AddPostViewModel::class.java]

        setContentView(binding.root)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
    }

    override fun onResume() {
        super.onResume()
        observeAll()
    }

    fun observeAll() {
        viewModel.newProductCallBack.observe(this) {
            val intent = Intent()
            val product = Product(viewModel.name.value.orEmpty(), viewModel.code.value.orEmpty().toInt(), viewModel.description.value.orEmpty())
            intent.putExtra("product", product)

            setResult(RESULT_OK, intent)
            finish()
        }

        viewModel.error.observe(this) {
            if (!it.isNullOrEmpty()) {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        }
    }
}