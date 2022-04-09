package co.edu.unab.mgads.jdcn.storeapp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import co.edu.unab.mgads.jdcn.storeapp.model.entity.Product
import co.edu.unab.mgads.jdcn.storeapp.model.repository.ProductRepository
import co.edu.unab.mgads.jdcn.storeapp.view.ProductAdapter

class ProductListActivityViewModel(application: Application):AndroidViewModel(application) {

    var products: ArrayList<Product> = arrayListOf()
    private val productRepository:ProductRepository= ProductRepository(application)

    init {
        loadProducts()
    }

    fun loadProducts(){
        products= productRepository.getAllLocal()
    }

    fun deleteproduct(myProduct: Product){
        productRepository.deleteLocal(myProduct)
        loadProducts()
    }

}