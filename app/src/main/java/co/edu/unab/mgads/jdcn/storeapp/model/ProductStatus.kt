package co.edu.unab.mgads.jdcn.storeapp.model

enum class ProductStatus (val value:Int) {
    AVAILABLE(1), SENT(2), SOLD(3);

    fun description():String{
        return when(this){
            AVAILABLE -> "Objeto Disponible"
            SENT -> "Objeto Vendido"
            SOLD -> "Objeto Agotado"
        }
    }
}