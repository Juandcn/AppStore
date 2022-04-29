package co.edu.unab.mgads.jdcn.storeapp.model.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import co.edu.unab.mgads.jdcn.storeapp.model.entity.Product

@Dao
interface ProductDAO {

    @Query("select * from Products")
    fun getAll():LiveData<List<Product>>

    @Query("select * from Products where `key`=:keyValue")
    fun getByKey(keyValue:Int):LiveData<Product>

    @Insert
    fun add(myProduct: Product)

    @Update
    fun update(myProduct: Product)

    @Delete
    fun delete(myProduct: Product)

}