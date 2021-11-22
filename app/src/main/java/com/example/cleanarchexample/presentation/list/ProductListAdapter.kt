package com.example.cleanarchexample.presentation.list

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchexample.R
import com.example.cleanarchexample.databinding.LayoutCardItemBinding
import com.squareup.picasso.Picasso

class ProductListAdapter constructor(
    private val context: Context?,
    private val viewModel: ProductListViewModel,
    private val itemClick: (position: Int) -> Unit
) : RecyclerView.Adapter<ProductListAdapter.ProductItemViewHolder>() {

    class ProductItemViewHolder(val itemDataBinding: LayoutCardItemBinding) :
        RecyclerView.ViewHolder(itemDataBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductItemViewHolder {
        val itemBinding = DataBindingUtil.inflate<LayoutCardItemBinding>(
            LayoutInflater.from(context),
            R.layout.layout_card_item,
            parent,
            false
        )

        return ProductItemViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ProductItemViewHolder, position: Int) {
        viewModel.productList.value?.get(position)?.let {
            Picasso.get().load(it.imageUrls.firstOrNull())
                .placeholder(R.drawable.product_placeholder)
                .into(holder.itemDataBinding.productImage)
            holder.itemDataBinding.productName.text = it.name?.capitalize()
            holder.itemDataBinding.productPrice.text = it.price
            holder.itemView.setOnClickListener { itemClick.invoke(position) }
        }
    }

    override fun getItemCount() = viewModel.productList.value?.size ?: 0
}