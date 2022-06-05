package co.edu.unab.mgads.jdcn.storeapp.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import co.edu.unab.mgads.jdcn.storeapp.model.ProductStatus
import com.google.firebase.firestore.Exclude
import com.google.firebase.firestore.PropertyName
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "Products")
data class Product(
            @PrimaryKey(autoGenerate = true)
            @JvmField @Exclude
            @Expose(serialize = false,deserialize = false)
            var key:Int?=null,
            @Ignore
            @JvmField @Exclude
            @Expose(serialize = false,deserialize = false)
            var id:String="",
            var name:String="",
            var price:Int=0,
            //@ColumnInfo (name="UrlImage")
            @JvmField @PropertyName("url_image")
            @SerializedName("url_image")
            var urlImage:String = "https://img2.freepng.es/20190523/ubz/kisspng-inventory-control-inventory-management-software-cl-5ce67fdca884a6.7345685315586098846903.jpg",
            var description:String="",
            var status: ProductStatus = ProductStatus.AVAILABLE
) :Serializable {
/*
    init {
        println("Producto creado:$name- $price")}

    @Exclude
    fun getShortInfo():String= "$name - $price"
    override fun toString():String="Product(name='$name', precio=$price)"*/
}