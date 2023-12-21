package com.islamzada.project2.features.productlist

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.ViewModelProvider
import com.islamzada.project2.R
import com.islamzada.project2.databinding.ActivityMainBinding
import com.islamzada.project2.features.adapters.ProductListAdapter
import com.islamzada.project2.features.details.DetailsActivity
import com.islamzada.project2.features.model.Product
import com.islamzada.project2.features.newproduct.AddProductActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel : MainViewModel

    lateinit var adapter : ProductListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding = ActivityMainBinding.inflate(layoutInflater)


        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        setContentView(binding.root)

//        val items = mutableListOf<Product>()

        adapter = ProductListAdapter (this.baseContext, mutableListOf(), onClick = {
        println("Clicked:  Name = ${it.name}, Code = ${it.code}, Description = ${it.desc}")
            openDetailsActivity(it)
        })

        binding.productList.adapter = adapter
    }


    //
    fun openDetailsActivity(product: Product) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("name", product.name)
        intent.putExtra("code", product.code)
        intent.putExtra("desc", product.desc)
        startActivity(intent)
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
            item?.let {
                adapter.addNewItem(it)
            }
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
        viewModel.addProductObserver.postValue(false)
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