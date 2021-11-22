package com.example.cleanarchexample.presentation.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.base.BaseFragment
import com.example.cleanarchexample.R
import com.example.cleanarchexample.databinding.FragmentProductListBinding
import com.example.cleanarchexample.presentation.HomeActivity
import com.example.cleanarchexample.presentation.detail.ProductDetailsFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductListFragment :
    BaseFragment<FragmentProductListBinding>(R.layout.fragment_product_list) {

    override val viewModel by viewModels<ProductListViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataBinding.recyclerView.layoutManager = GridLayoutManager(context, 2)
        dataBinding.recyclerView.adapter = ProductListAdapter(context, viewModel) {
            (activity as HomeActivity).replaceFragment(ProductDetailsFragment.newInstance(viewModel.productList.value?.get(it)))
        }
        viewModel.productList.observe(viewLifecycleOwner, Observer {
            (dataBinding.recyclerView.adapter as ProductListAdapter).notifyDataSetChanged()
        })

        viewModel.getProducts()
    }

}