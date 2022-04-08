package co.edu.unab.mgads.jdcn.storeapp.entregable1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import co.edu.unab.mgads.jdcn.storeapp.R
import co.edu.unab.mgads.jdcn.storeapp.databinding.ActivityListUserBinding
import co.edu.unab.mgads.jdcn.storeapp.viewModel.ListUserViewModel
import co.edu.unab.mgads.jdcn.storeapp.viewModel.ProductListActivityViewModel

class ListUserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListUserBinding
    private lateinit var viewModel:ListUserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_list_user)
        viewModel= ViewModelProvider(this)[ListUserViewModel::class.java]

        binding.viewModel=viewModel
        viewModel.loadUsers()
        viewModel.refresData()

    }
}