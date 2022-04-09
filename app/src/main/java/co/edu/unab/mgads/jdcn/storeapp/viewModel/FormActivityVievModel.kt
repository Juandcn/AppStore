package co.edu.unab.mgads.jdcn.storeapp.viewModel

import androidx.lifecycle.ViewModel
import co.edu.unab.mgads.jdcn.storeapp.model.entity.User

class FormActivityVievModel:ViewModel() {

    var user: User = User("","","","","")

    fun registro():String{
        return "Se creo el usuario ${user.name} con cedula ${user.document} y correo ${user.email}"
    }
}