package co.edu.unab.mgads.jdcn.storeapp.view

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import co.edu.unab.mgads.jdcn.storeapp.R
import co.edu.unab.mgads.jdcn.storeapp.databinding.ActivityFormBinding
import co.edu.unab.mgads.jdcn.storeapp.viewModel.FormActivityVievModel

class FormActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFormBinding
    private lateinit var viewModel:FormActivityVievModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_form)
        viewModel= ViewModelProvider(this)[FormActivityVievModel::class.java]

        binding.viewModel=viewModel
        binding.FormBtRegister.setOnClickListener {
            viewModel.SingUp().observe(this) {}
            it?.let {
                login(it)
            } ?: run {
                Toast.makeText(applicationContext, "Error al crear el Usuario", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        binding.FormBtVolver.setOnClickListener {
         finish()
        }
    }

    private fun login (it: View){
        val preferences: SharedPreferences =
            getSharedPreferences("unabApp.pref", MODE_PRIVATE)
        val editor: SharedPreferences.Editor = preferences.edit()
        editor.putBoolean("login", true)
        editor.apply()

        val intentlogin: Intent =
            Intent(applicationContext, ProductListActivity::class.java)
        intentlogin.apply {
            putExtra("message", "Hola")
            putExtra("data", viewModel.user.email)
        }
        startActivity(intentlogin)
        Toast.makeText(this, "Iniciando sesion....", Toast.LENGTH_SHORT).show()
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }
}