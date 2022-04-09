package co.edu.unab.mgads.jdcn.storeapp.model

import java.io.Serializable

data class Product(var name:String,
                   val price:Int,
                   val urlImage:String = "http://nycinventarios.com/wp-content/uploads/2020/05/iconos.png",
                   var description:String="", val status: ProductStatus = ProductStatus.AVAILABLE) :Serializable {

    init {
        println("Producto creado:$name- $price")
    }

    fun getShortInfo():String= "$name - $price"
    override fun toString():String="Product(name='$name', precio=$price)"
}