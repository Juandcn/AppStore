package co.edu.unab.mgads.jdcn.storeapp.model

data class Product(var name:String,
                   val urlImage:String ="http://nycinventarios.com/wp-content/uploads/2020/05/iconos.png",
                   val price:Int, var description:String="", val status: ProductStatus = ProductStatus.AVAILABLE) {

    init {
        println("Producto creado:$name- $price")
    }

    fun getShortInfo():String= "$name - $price"
    override fun toString():String="Product(name='$name', precio=$price)"
}