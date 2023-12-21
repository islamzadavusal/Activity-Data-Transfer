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

class ProductListAdapter(val context: Context, private var productList: MutableList<Product>) : BaseAdapter() {
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

        var newConvertView = convertView

        var holder : ViewHolder

        if (convertView == null) {
            val binding: ListItemProductBinding = DataBindingUtil.inflate(
                LayoutInflater.from(context),
                R.layout.list_item_product,
                parent,
                false
            )

            newConvertView = binding.root
            holder = ViewHolder(binding)
            holder.bind(productList[position])

            newConvertView?.tag = holder

            return binding.root

        } else {
            holder = convertView.tag as ViewHolder
            holder.bind(productList[position])
        }

        return newConvertView!!
    }

    private class ViewHolder(var binding: ListItemProductBinding) {
        fun bind(product: Product){

            binding.productName.text = product.name
            binding.productCode.text = product.code.toString()
            binding.productDetail.text = product.desc
        }


    }

}