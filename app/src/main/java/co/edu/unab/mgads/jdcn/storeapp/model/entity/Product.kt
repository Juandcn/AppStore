package co.edu.unab.mgads.jdcn.storeapp.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import co.edu.unab.mgads.jdcn.storeapp.model.ProductStatus
import com.google.firebase.firestore.Exclude
import com.google.firebase.firestore.PropertyName
import java.io.Serializable

@Entity(tableName = "Products")
data class Product(
            @PrimaryKey(autoGenerate = true)
            @JvmField @Exclude
            var key:Int?=null,
            @Ignore
            @JvmField @Exclude
            var id:String="",
            var name:String="",
            var price:Int=0,
            @ColumnInfo (name="UrlImage")
            @JvmField @PropertyName("url_image")
            var urlImage:String = "http://nycinventarios.com/wp-content/uploads/2020/05/iconos.png",
            var description:String="",
            var status: ProductStatus = ProductStatus.AVAILABLE
) :Serializable {

    init {
        println("Producto creado:$name- $price")
    }

    @Exclude
    fun getShortInfo():String= "$name - $price"
    override fun toString():String="Product(name='$name', precio=$price)"
}