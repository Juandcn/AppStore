package co.edu.unab.mgads.jdcn.storeapp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import co.edu.unab.mgads.jdcn.storeapp.model.entity.Product
import co.edu.unab.mgads.jdcn.storeapp.model.repository.ProductRepository

class ProductDetailActivityViewModel(application: Application):AndroidViewModel(application) {

    private val productRepository:ProductRepository = ProductRepository(application)
    lateinit var product:LiveData<Product>

    fun getProductByKey(productKey : Int){
        product=productRepository.getByKeyLocal(productKey)
    }
}