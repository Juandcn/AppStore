package co.edu.unab.mgads.jdcn.storeapp.viewModel

import androidx.lifecycle.ViewModel
import co.edu.unab.mgads.jdcn.storeapp.Product
import co.edu.unab.mgads.jdcn.storeapp.ProductAdapter

class ProductListActivityViewModel:ViewModel() {

    private val products:ArrayList<Product> = arrayListOf()
    val adapter:ProductAdapter = ProductAdapter(products)

    fun loadProducts(){
        products.apply {
            clear()
            add(Product("Monitor",500000))
            add(Product("Teclado",300000))
            add(Product("Mouse",200000))
            add(Product("CPU",1000000))
        }
    }

    fun refresData(){
        adapter.refresh(products)
    }
}