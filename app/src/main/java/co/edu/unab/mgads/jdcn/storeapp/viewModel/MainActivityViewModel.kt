/*
Software desarrollado por Juan David Celis
 */

package co.edu.unab.mgads.jdcn.storeapp.viewModel

import androidx.lifecycle.ViewModel
import co.edu.unab.mgads.jdcn.storeapp.model.entity.User

class MainActivityViewModel: ViewModel() {

    var user: User = User("","","","","")

    fun login():Boolean{
        return user.email=="juan.correo@gmail.com" && user.password=="123456789"
    }
}