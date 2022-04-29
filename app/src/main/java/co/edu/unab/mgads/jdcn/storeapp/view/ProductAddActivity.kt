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

        val myProduct:Product?=intent.getSerializableExtra("product") as Product
        binding=DataBindingUtil.setContentView(this,R.layout.activity_product_add)

        viewModel=ViewModelProvider(this)[ProductAddActivityViewModel::class.java]
        binding.viewModel=viewModel

        myProduct?.let {
            binding.FormTvTitleAddproduct.text="Editar ${it.name}"
            viewModel.product=it
            binding.FormBtRegister.text="Editar Producto"
            binding.FormBtRegister.setOnClickListener{
                viewModel.edit()
                finish()
            }
        }?:run {
            binding.FormBtRegister.setOnClickListener{
                viewModel.add()
                finish()
            }
        }

        binding.viewModel=viewModel

    }
}