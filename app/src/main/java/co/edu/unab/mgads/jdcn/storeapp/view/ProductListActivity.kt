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
    lateinit var adapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var bundle:Bundle? = intent.extras
        var message:String? = bundle?.getString("message")
        var data:String? = intent.getStringExtra("data")

        title="$message $data"
        binding = DataBindingUtil.setContentView(this, R.layout.activity_product_list)
        viewModel= ViewModelProvider(this)[ProductListActivityViewModel::class.java]

        adapter= ProductAdapter(viewModel.products)
        binding.adapter=adapter
        adapter.onItemClickListener={
            Toast.makeText(applicationContext, it.name,Toast.LENGTH_SHORT).show()

            val intentDetail = Intent(applicationContext, ProductDetailActivity::class.java)
            intentDetail.putExtra("product", it)
            startActivity(intentDetail)
        }

        adapter.onItemLongClickListener={
            viewModel.deleteproduct(it)
            adapter.refresh(viewModel.products)
            Toast.makeText(applicationContext,"Producto ${it.name} eliminado",Toast.LENGTH_SHORT).show()
        }

        binding.ListBtAdd.setOnClickListener {
            startActivity(Intent(applicationContext, ProductAddActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadProducts()
        adapter.refresh(viewModel.products)
    }

}