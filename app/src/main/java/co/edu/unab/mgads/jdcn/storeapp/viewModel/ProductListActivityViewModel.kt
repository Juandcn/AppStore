package co.edu.unab.mgads.jdcn.storeapp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import co.edu.unab.mgads.jdcn.storeapp.model.entity.Product
import co.edu.unab.mgads.jdcn.storeapp.model.repository.ProductRepository
import co.edu.unab.mgads.jdcn.storeapp.view.ProductAdapter

class ProductListActivityViewModel(application: Application):AndroidViewModel(application) {

    private val productRepository:ProductRepository= ProductRepository(application)
    var products: LiveData<List<Product>> = productRepository.products

    fun deleteproduct(myProduct: Product): LiveData<Boolean> {
        //productRepository.deleteLocal(myProduct)
        return productRepository.deleteFirestore(myProduct)
    }

    fun addProduct(newProduct: Product){
        productRepository.addLocal(newProduct)
    }

    fun loadFakeData(){
        productRepository.loadFakeData()
    }

    fun loadProducts(){
        //productRepository.loadAllLocal()
        productRepository.loadAllFirestore()
        //productRepository.listenAllFirestore()
    }
}