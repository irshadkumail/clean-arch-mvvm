package com.example.cleanarchexample.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.base.BaseActivity
import com.example.base.BaseFragment
import com.example.base.EmptyViewModel
import com.example.cleanarchexample.R
import com.example.cleanarchexample.databinding.ActivityHomeBinding
import com.example.cleanarchexample.presentation.list.ProductListFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity<ActivityHomeBinding>(R.layout.activity_home) {

    override val viewModel by viewModels<EmptyViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        replaceFragment(ProductListFragment())
    }

    fun replaceFragment(fragment: Fragment, addToBackStack: Boolean = true) {
        supportFragmentManager.commit {
            replace(R.id.frameLayout, fragment)
            if (addToBackStack) addToBackStack(fragment.tag)
        }
    }

}