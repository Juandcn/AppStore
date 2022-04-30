package co.edu.unab.mgads.jdcn.storeapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import co.edu.unab.mgads.jdcn.storeapp.model.entity.User
import co.edu.unab.mgads.jdcn.storeapp.model.repository.UserRepository

class FormActivityVievModel:ViewModel() {

    var user: User = User("","","","","")
    var password:String=""
    private val userRepository =UserRepository()

    fun SingUp():LiveData<User?>{
        return userRepository.singUp(user, password)
    }

//    fun registro():String{
//        return "Se creo el usuario ${user.name} con cedula ${user.document} y correo ${user.email}"
//    }

}