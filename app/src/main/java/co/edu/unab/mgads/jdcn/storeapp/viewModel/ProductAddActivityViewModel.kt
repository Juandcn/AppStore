package co.edu.unab.mgads.jdcn.storeapp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import co.edu.unab.mgads.jdcn.storeapp.model.entity.Product
import co.edu.unab.mgads.jdcn.storeapp.model.repository.ProductRepository


class ProductAddActivityViewModel(application: Application):AndroidViewModel(application) {

    private val productRepository:ProductRepository= ProductRepository(application)
    var product= Product(name = "", price = 0)

    fun add(){
        //productRepository.addLocal(product)
        productRepository.addFirestore(product)
    }

    fun edit(){
        productRepository.updateFirestore(product)
    }

}
