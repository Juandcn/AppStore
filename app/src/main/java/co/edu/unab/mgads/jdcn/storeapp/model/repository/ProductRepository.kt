package co.edu.unab.mgads.jdcn.storeapp.model.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import co.edu.unab.mgads.jdcn.storeapp.model.entity.Product
import co.edu.unab.mgads.jdcn.storeapp.model.local.StoreAppDB
import co.edu.unab.mgads.jdcn.storeapp.model.local.dao.ProductDAO
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class ProductRepository (myContext: Context) {

    private val PRODUCT_COLLECTION:String="products"
    private val db:StoreAppDB = StoreAppDB.getInstance(myContext)
    private val productDao:ProductDAO = db.productDAO()
    var products: MutableLiveData<List<Product>> = MutableLiveData()
    var product: MutableLiveData<Product> = MutableLiveData()
    private val firestore: FirebaseFirestore = Firebase.firestore

    init {
        loadAllLocal()
    }

    fun loadAllLocal(){
        val productsList= productDao.getAll()
        products.value=productsList as List<Product>
        println("Se traen datos")
    }

    fun loadAllFirestore (){
        firestore.collection(PRODUCT_COLLECTION).get().addOnSuccessListener { result ->
            val productsList:ArrayList<Product> = arrayListOf()
            if (!result.isEmpty){
                for (document in result.documents){
                    val myProduct:Product?=document.toObject(Product::class.java)
                    myProduct?.let {
                        it.id=document.id
                        productsList.add(it)
                    }
                }
            }
            products.value=productsList
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

    fun getByIdFirestore(id:String){
        firestore.collection(PRODUCT_COLLECTION).document(id).get().addOnSuccessListener { result ->
            val myProduct:Product?=result.toObject(Product::class.java)
            myProduct?.let {
                it.id=id
                product.value=it
            }
        }
    }

    fun addLocal(myProduct: Product){
        return productDao.add(myProduct)
    }

    fun addFirestore(myProduct: Product){
        firestore.collection(PRODUCT_COLLECTION).add(myProduct)
    }

    fun updateLocal(myProduct: Product){
        return productDao.update(myProduct)
    }

    fun updateFirestore(myProduct: Product){
        firestore.collection(PRODUCT_COLLECTION).document(myProduct.id).set(myProduct)
    }

    fun deleteLocal(myProduct: Product){
        return productDao.delete(myProduct)
        loadAllLocal()
    }

    fun deleteFirestore(myProduct: Product){
        firestore.collection(PRODUCT_COLLECTION).document(myProduct.id).delete()
        loadAllFirestore()
    }

}