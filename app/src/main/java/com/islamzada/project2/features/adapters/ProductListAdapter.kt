package com.islamzada.project2.features.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.databinding.DataBindingUtil
import com.islamzada.project2.R
import com.islamzada.project2.databinding.ListItemProductBinding
import com.islamzada.project2.features.model.Product

class ProductListAdapter(private var productList: MutableList<Product>, val context: Context) : BaseAdapter() {
    override fun getCount(): Int {
        return productList.count()
    }

    override fun getItem(position: Int): Any {
        return productList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val binding : ListItemProductBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.list_item_product,
            parent,
            false
        )

        return binding.root


    }
}