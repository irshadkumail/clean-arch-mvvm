package com.example.cleanarchexample.presentation.detail;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import com.example.base.BaseFragment;
import com.example.cleanarchexample.R;
import com.example.cleanarchexample.databinding.FragmentProductDetailBinding;
import com.example.cleanarchexample.domain.Product;
import com.squareup.picasso.Picasso;

public class ProductDetailsFragment extends BaseFragment<FragmentProductDetailBinding> {


    private ProductDetailsFragment() {
        super(R.layout.fragment_product_detail);
    }

    public static ProductDetailsFragment newInstance(Product product) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("parcelable", product);
        ProductDetailsFragment fragment = new ProductDetailsFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @NonNull
    @Override
    public ViewModel getViewModel() {
        return ViewModelProviders.of(this).get(ProductDetailViewModel.class);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Product product = getArguments().getParcelable("parcelable");

        Picasso.get().load(product.getImageUrls().get(0)).placeholder(R.drawable.product_placeholder).into(dataBinding.imageView);
        dataBinding.productName.setText(product.getName());
        dataBinding.productPrice.setText(product.getPrice());
    }
}
