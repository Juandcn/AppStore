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
        val productId: String = productKey as String
        //product=productRepository.getByKeyLocal(productKey)
        productRepository.getByIdFirestore(productId)
        product = productRepository.product

    }

    fun getProductById(myProductId : String){
        productRepository.getByIdFirestore(myProductId)
        product=productRepository.product

    }
}