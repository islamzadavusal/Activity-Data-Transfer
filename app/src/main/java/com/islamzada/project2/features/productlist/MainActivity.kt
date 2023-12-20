package com.islamzada.project2.features.productlist

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.ViewModelProvider
import com.islamzada.project2.R
import com.islamzada.project2.databinding.ActivityMainBinding
import com.islamzada.project2.features.model.Product
import com.islamzada.project2.features.newproduct.AddProductActivity

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
    }

    fun openAddProductActivity(){
        val intent = Intent(this, AddProductActivity::class.java)
//        startActivity(intent)
        newProductLauncher.launch(intent)
    }


    private val newProductLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if (it.resultCode == Activity.RESULT_OK){
            val item = it.data?.getParcelableExtra<Product>("product")
            println(item)
        }
    }


    fun observeAll(){
        viewModel.addProductObserver.observe(this){
            if (it){
                openAddProductActivity()
            }
        }
    }


    fun removeObserve(){
        viewModel.addProductObserver.removeObservers(this)
    }


    override fun onResume() {
        super.onResume()
        observeAll()
    }


    override fun onPause() {
        super.onPause()
        removeObserve()
    }

}