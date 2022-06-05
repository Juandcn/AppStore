package co.edu.unab.mgads.jdcn.storeapp.viewModel

import android.app.Application
import android.net.Uri
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import co.edu.unab.mgads.jdcn.storeapp.model.entity.Product
import co.edu.unab.mgads.jdcn.storeapp.model.repository.ProductRepository


class ProductAddActivityViewModel(application: Application):AndroidViewModel(application) {

    private val productRepository:ProductRepository= ProductRepository(application)
    var product= Product(name = "", price = 0)

    fun add(myProduct: Product,photoUri: Uri?): LiveData<String> {
        //productRepository.addLocal(product)
        return productRepository.addFirestore(myProduct,photoUri)
    }

    fun update(myProduct: Product): LiveData<Boolean> {
        return productRepository.updateFirestore(myProduct)
    }

    fun getImage(urlString:String){
    }

}
