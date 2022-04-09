package co.edu.unab.mgads.jdcn.storeapp.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import co.edu.unab.mgads.jdcn.storeapp.R
import co.edu.unab.mgads.jdcn.storeapp.model.User
import co.edu.unab.mgads.jdcn.storeapp.databinding.UserDataBinding

class UserAdapter (private var users:ArrayList<User>): RecyclerView.Adapter<UserAdapter.UserViewHolder>(){

    fun refresh(listUsers: ArrayList<User>){
        users=listUsers
        notifyDataSetChanged()
    }

    class UserViewHolder(private  val binding: UserDataBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(listUsers: User){
            binding.user=listUsers
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflate= LayoutInflater.from(parent.context)
        val binding: UserDataBinding = DataBindingUtil.inflate(inflate,
            R.layout.user_data,parent,false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount(): Int= users.size
}