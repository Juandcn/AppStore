package co.edu.unab.mgads.jdcn.storeapp.viewModel

import androidx.lifecycle.ViewModel
import co.edu.unab.mgads.jdcn.storeapp.model.entity.User
import co.edu.unab.mgads.jdcn.storeapp.view.UserAdapter

class ListUserViewModel:ViewModel() {

    private val users:ArrayList<User> = arrayListOf()
    var adapter: UserAdapter = UserAdapter(users)

    fun loadUsers(){
        users.apply {
            clear()
            add(User("Juan","102256", "Juan@gmail.com","www.juan.com", "Juan01" ))
            add(User("Maria","102250", "Maria@gmail.com","www.Pic.com", "Abcnd" ))
            add(User("Andreina","102253", "Andre@gmail.com","www.Foto.com", "02014" ))
            add(User("David","102254", "David@gmail.com","www.Imagen.com", "A.D1098" ))
        }
    }

    fun refresData(){
        adapter.refresh(users)
    }
}