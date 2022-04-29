package co.edu.unab.mgads.jdcn.storeapp.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import co.edu.unab.mgads.jdcn.storeapp.model.ProductStatus
import java.io.Serializable

@Entity(tableName = "Products")
class Product(@PrimaryKey(autoGenerate = true) var key:Int?=null,
                   var name:String, var price:Int,
                   @ColumnInfo (name="UrlImage") var urlImage:String = "http://nycinventarios.com/wp-content/uploads/2020/05/iconos.png",
                   var description:String="", val status: ProductStatus = ProductStatus.AVAILABLE
) :Serializable {

    init {
        println("Producto creado:$name- $price")
    }

    fun getShortInfo():String= "$name - $price"
    override fun toString():String="Product(name='$name', precio=$price)"
}