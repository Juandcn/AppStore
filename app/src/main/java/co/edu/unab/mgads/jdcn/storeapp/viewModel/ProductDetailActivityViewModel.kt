package co.edu.unab.mgads.jdcn.storeapp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import co.edu.unab.mgads.jdcn.storeapp.model.entity.Product
import co.edu.unab.mgads.jdcn.storeapp.model.repository.ProductRepository

class ProductDetailActivityViewModel(application: Application):AndroidViewModel(application) {

    private val productRepository:ProductRepository = ProductRepository(application)
    var product= Product(name="",price=0)

    fun getProductByKey(myProductKey: Int){
        product=productRepository.getByKeyLocal(myProductKey)

    }
}