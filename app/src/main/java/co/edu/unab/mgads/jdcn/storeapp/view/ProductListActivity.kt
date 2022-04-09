package co.edu.unab.mgads.jdcn.storeapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import co.edu.unab.mgads.jdcn.storeapp.R
import co.edu.unab.mgads.jdcn.storeapp.databinding.ActivityProductListBinding
import co.edu.unab.mgads.jdcn.storeapp.viewModel.ProductListActivityViewModel

class ProductListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductListBinding
    private lateinit var viewModel:ProductListActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var bundle:Bundle? = intent.extras
        var message:String? = bundle?.getString("message")
        var data:String? = intent.getStringExtra("data")

        title="$message $data"
        binding = DataBindingUtil.setContentView(this, R.layout.activity_product_list)
        viewModel= ViewModelProvider(this)[ProductListActivityViewModel::class.java]

        binding.viewModel=viewModel
        viewModel.loadProducts()
        viewModel.refresData()

        viewModel.adapter.onItemClickListener={
            Toast.makeText(applicationContext, it.name,Toast.LENGTH_SHORT).show()

            val intentDetail = Intent(applicationContext, ProductListActivity::class.java)
            intentDetail.putExtra("product", it)
            startActivity(intentDetail)
        }

    }
}