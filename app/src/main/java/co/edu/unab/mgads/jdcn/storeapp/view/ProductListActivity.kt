package co.edu.unab.mgads.jdcn.storeapp.view

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import co.edu.unab.mgads.jdcn.storeapp.R
import co.edu.unab.mgads.jdcn.storeapp.databinding.ActivityProductListBinding
import co.edu.unab.mgads.jdcn.storeapp.model.entity.Product
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

        adapter= ProductAdapter(arrayListOf())
        binding.adapter=adapter

        loadProducts()

//        viewModel.products.observe(this){
//            if (it.isEmpty()){
//                viewModel.loadFakeData()
//            }
//            adapter.refresh(it as ArrayList<Product>)
//        }

        adapter.onItemClickListener={
            Toast.makeText(applicationContext, it.name,Toast.LENGTH_SHORT).show()

            val intentDetail = Intent(applicationContext, ProductDetailActivity::class.java)
            intentDetail.putExtra("product", it)
            startActivity(intentDetail)
        }

        adapter.onItemLongClickListener={
            viewModel.deleteproduct(it)
            Toast.makeText(applicationContext,"Producto ${it.name} eliminado",Toast.LENGTH_SHORT).show()
        }

        binding.ListBtAdd.setOnClickListener {
            startActivity(Intent(applicationContext, ProductAddActivity::class.java))
        }
    }

    private fun loadProducts(){
        viewModel.products.observe(this){
            if (it.isEmpty()){
                viewModel.loadFakeData()
            }
            adapter.refresh(it as ArrayList<Product>)
        }
    }
    override fun onResume() {
        super.onResume()
        viewModel.loadProducts()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.mi_logout ->{
                logout()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun logout(){
        val preferences:SharedPreferences=getSharedPreferences("store_app-pref", MODE_PRIVATE)
        val editor=preferences.edit()
        editor.clear()
        editor.apply()

        val intent=Intent(applicationContext, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }

}