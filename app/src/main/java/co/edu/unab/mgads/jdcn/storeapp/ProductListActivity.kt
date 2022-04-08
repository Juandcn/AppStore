package co.edu.unab.mgads.jdcn.storeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import co.edu.unab.mgads.jdcn.storeapp.databinding.ActivityProductListBinding
import co.edu.unab.mgads.jdcn.storeapp.viewModel.MainActivityViewModel
import co.edu.unab.mgads.jdcn.storeapp.viewModel.ProductListActivityViewModel

class ProductListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductListBinding
    private lateinit var viewModel:ProductListActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_product_list)
        viewModel= ViewModelProvider(this)[ProductListActivityViewModel::class.java]

        binding.viewModel=viewModel
        viewModel.loadProducts()
        viewModel.refresData()

    }
}