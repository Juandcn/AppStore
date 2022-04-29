package co.edu.unab.mgads.jdcn.storeapp.model.repository

import android.content.Context
import androidx.lifecycle.LiveData
import co.edu.unab.mgads.jdcn.storeapp.model.entity.Product
import co.edu.unab.mgads.jdcn.storeapp.model.local.StoreAppDB
import co.edu.unab.mgads.jdcn.storeapp.model.local.dao.ProductDAO

class ProductRepository (myContext: Context) {

    private val db:StoreAppDB = StoreAppDB.getInstance(myContext)
    private val productDao:ProductDAO = db.productDAO()
    lateinit var products:LiveData<List<Product>>

    init {
        loadAllLocal()
    }

    fun loadAllLocal(){
        products= productDao.getAll()
        products.value?.let {
            if (it.isEmpty()) {
                loadFakeData()
            }
        }
    }

    fun loadFakeData() {
        productDao.apply {
            add(Product(name="Monitor",price= 500000))
            add(Product(name="Teclado",price= 300000))
            add(Product(name="Mouse",price= 200000))
            add(Product(name="CPU",price= 8000000))
        }
    }

    fun getByKeyLocal(key:Int):LiveData<Product>{
        return productDao.getByKey(key)
    }

    fun addLocal(myProduct: Product){
        return productDao.add(myProduct)

    }

    fun updateLocal(myProduct: Product){
        return productDao.update(myProduct)

    }

    fun deleteLocal(myProduct: Product){
        return productDao.delete(myProduct)
    }

}