/*
Software desarrollado por Juan David Celis
 */

package co.edu.unab.mgads.jdcn.storeapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import co.edu.unab.mgads.jdcn.storeapp.model.entity.User
import co.edu.unab.mgads.jdcn.storeapp.model.repository.UserRepository

class MainActivityViewModel: ViewModel() {

    var user: User = User("","","","","")
    var password:String=""
    private val userRepository=UserRepository()

      fun login(): LiveData<User?> {
//        return user.email=="juan.correo@gmail.com" && user.password=="123456789"
          return userRepository.login(user.email,password)
      }
}