package co.edu.unab.mgads.jdcn.storeapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import co.edu.unab.mgads.jdcn.storeapp.R
import co.edu.unab.mgads.jdcn.storeapp.databinding.ActivityProductAddBinding
import co.edu.unab.mgads.jdcn.storeapp.model.entity.Product
import co.edu.unab.mgads.jdcn.storeapp.viewModel.ProductAddActivityViewModel

class ProductAddActivity : AppCompatActivity() {

    private lateinit var binding:ActivityProductAddBinding
    private lateinit var viewModel:ProductAddActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=DataBindingUtil.setContentView(this,R.layout.activity_product_add)

        viewModel=ViewModelProvider(this)[ProductAddActivityViewModel::class.java]

        binding.viewModel=viewModel
        binding.FormBtRegister.setOnClickListener{
            viewModel.add()
            finish()
        }
    }
}