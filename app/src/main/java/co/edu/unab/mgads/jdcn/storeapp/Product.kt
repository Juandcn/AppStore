package co.edu.unab.mgads.jdcn.storeapp

data class Product(var name:String, val price:Int, var description:String="", val status:ProductStatus=ProductStatus.AVAILABLE) {

    init {
        println("Producto creado:$name- $price")
    }

    fun getShortInfo():String= "$name - $price"
    override fun toString():String="Product(name='$name', precio=$price)"
}