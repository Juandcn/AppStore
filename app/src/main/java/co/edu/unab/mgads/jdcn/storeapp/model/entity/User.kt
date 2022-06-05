package co.edu.unab.mgads.jdcn.storeapp.model.entity

import com.google.firebase.firestore.Exclude
import com.google.firebase.firestore.PropertyName

open class User(
    @JvmField @Exclude
    var id:String,
    var name:String="",
    var document:String="",
    var email:String="",
    @JvmField @PropertyName("Url_Photo")
    var urlpic:String="https://images.vexels.com/media/users/3/135246/isolated/preview/df491bf444acfa945630c22389140d4a-icono-de-sombra-de-usuario.png") {

    /*open fun login():Boolean{
        return name=="juancorreo@gmail.com" && password=="12456789"
    }*/
    //abstract fun showInfo ()
}
