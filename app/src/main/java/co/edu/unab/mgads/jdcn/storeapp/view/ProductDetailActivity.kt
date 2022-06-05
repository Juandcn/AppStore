package co.edu.unab.mgads.jdcn.storeapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import co.edu.unab.mgads.jdcn.storeapp.R
import co.edu.unab.mgads.jdcn.storeapp.databinding.ActivityProductDetailBinding
import co.edu.unab.mgads.jdcn.storeapp.model.entity.Product
import co.edu.unab.mgads.jdcn.storeapp.viewModel.ProductDetailActivityViewModel

class ProductDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductDetailBinding
    private lateinit var viewModel: ProductDetailActivityViewModel
    private var myProductKey: Int = 0
    private var myProductId: String? = ""
    private var productKey = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        myProductKey=intent.getIntExtra("product_key",0)
        productKey = intent.getIntExtra("productKey",0)
        myProductId = intent.getStringExtra("product_id")

        binding=DataBindingUtil.setContentView(this,R.layout.activity_product_detail)
        viewModel=ViewModelProvider(this)[ProductDetailActivityViewModel::class.java]

        //viewModel.getProductByKey(myProductKey)
        myProductId?.let {viewModel.getProductById(it)}

        binding.product = Product()
        viewModel.product.observe(this){
            it?.let {
                binding.product=it
            }?:run {
                binding.product = Product()
            }
        }

        binding.DetailBtEdit.setOnClickListener {
           val intentForm= Intent(applicationContext, ProductAddActivity::class.java)
            intentForm.apply {
                putExtra("product", binding.product)
            }
            startActivity(intentForm)
        }
        binding.DetailBtReturn.setOnClickListener {
            finish()
        }
    }

    override fun onResume() {
        //viewModel.getProductByKey(myProductKey)
        myProductId?.let {viewModel.getProductById(it)}
        super.onResume()
    }
}
