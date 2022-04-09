package co.edu.unab.mgads.jdcn.storeapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import co.edu.unab.mgads.jdcn.storeapp.R
import co.edu.unab.mgads.jdcn.storeapp.databinding.ActivityProductDetailBinding
import co.edu.unab.mgads.jdcn.storeapp.model.Product
import co.edu.unab.mgads.jdcn.storeapp.viewModel.ProductDetailActivityViewModel

class ProductDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductDetailBinding
    private lateinit var viewModel: ProductDetailActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val myProduct:Product =intent.getSerializableExtra("product") as Product

        binding=DataBindingUtil.setContentView(this,R.layout.activity_product_detail)
        viewModel=ViewModelProvider(this)[ProductDetailActivityViewModel::class.java]
        binding.product=viewModel.product
    }
}