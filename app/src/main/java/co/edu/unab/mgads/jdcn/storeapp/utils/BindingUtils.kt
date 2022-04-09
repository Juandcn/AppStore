package co.edu.unab.mgads.jdcn.storeapp.utils

import android.view.ViewDebug
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseMethod
import com.bumptech.glide.Glide

@BindingAdapter("image")
fun loadImage(imageView: ImageView, url:String){
    Glide.with(imageView.context).load(url).into(imageView)
}

@InverseMethod("stringtoInt")
fun intToString(value:Int):String{
    return value.toString()
}

@InverseMethod("intToString")
fun stringtoInt(value:String):Int{
    if (value==""){
        return 0
    }
    return Integer.parseInt(value)

}