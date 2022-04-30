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
    var urlpic:String="") {

    /*open fun login():Boolean{
        return name=="juancorreo@gmail.com" && password=="12456789"
    }*/
    //abstract fun showInfo ()
}
