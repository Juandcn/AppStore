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
    private var productKey = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        myProductKey=intent.getIntExtra("product_key",0)
        productKey = intent.getIntExtra("productKey",0)

        binding=DataBindingUtil.setContentView(this,R.layout.activity_product_detail)
        viewModel=ViewModelProvider(this)[ProductDetailActivityViewModel::class.java]

        viewModel.product.observe(this){
            it?.let {
                binding.product=it
                productKey = it.key!!
            }
        }

        viewModel.getProductByKey(myProductKey)
        binding.product = Product(name = "", price = 0, description = "")

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
        viewModel.getProductByKey(myProductKey)
        super.onResume()
    }
}
