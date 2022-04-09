package co.edu.unab.mgads.jdcn.storeapp.model.repository

import android.content.Context
import co.edu.unab.mgads.jdcn.storeapp.model.entity.Product
import co.edu.unab.mgads.jdcn.storeapp.model.local.StoreAppDB
import co.edu.unab.mgads.jdcn.storeapp.model.local.dao.ProductDAO

class ProductRepository (myContext: Context) {

    private val db:StoreAppDB = StoreAppDB.getInstance(myContext)
    private val productDao:ProductDAO = db.productDAO()
    private var products:ArrayList<Product> = arrayListOf()

    fun getAllLocal():ArrayList<Product>{
        loadAllLocal()
        return products
    }

    fun loadAllLocal(){
        products= productDao.getAll() as ArrayList<Product>
        if (products.isEmpty()){
            loadFakeData()
        }
    }

    private fun loadFakeData() {
        productDao.apply {
            add(Product(name="Monitor",price= 500000))
            add(Product(name="Teclado",price= 300000))
            add(Product(name="Mouse",price= 200000))
            add(Product(name="CPU",price= 8000000))
        }
        loadAllLocal()
    }

    fun getByKeyLocal(key:Int):Product{
        return productDao.getByKey(key)
    }

    fun addLocal(myProduct: Product){
        return productDao.add(myProduct)
        loadAllLocal()
    }

    fun updateLocal(myProduct: Product){
        return productDao.update(myProduct)
        loadAllLocal()
    }

    fun deleteLocal(myProduct: Product){
        return productDao.delete(myProduct)
        loadAllLocal()
    }
}