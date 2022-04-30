package co.edu.unab.mgads.jdcn.storeapp.view

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import co.edu.unab.mgads.jdcn.storeapp.R
import co.edu.unab.mgads.jdcn.storeapp.viewModel.MainActivityViewModel
import co.edu.unab.mgads.jdcn.storeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    //private lateinit var user: User
    private lateinit var viewModel:MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val preferences = getSharedPreferences("unabApp.pref", MODE_PRIVATE)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        //preferences.edit().remove("login").apply()
        if (preferences.getBoolean("login", false)) {
            val intentlogin: Intent =
                Intent(applicationContext, ProductListActivity::class.java)
            intentlogin.apply {
                putExtra("message", "Hola")
                putExtra("data", viewModel.user.email)
            }
            startActivity(intentlogin)
        }

        binding.viewModel = viewModel
        //binding.LoginTvTitle.text="Modificado por codigo"
        binding.title = "Modificado por codigo"
        //val myClient:User = Client(name="juan Celis", password="123456789", document = "1090477444", urlpic = "www.foto.com", email = "juan@correo.com")
        //binding.user=myClient

        binding.LoginBtLogin.setOnClickListener {
        //Toast.makeText(this, "Se Oprimio el boton login", Toast.LENGTH_SHORT).show()
        //Toast.makeText(this,"En la cajita ${binding.LoginEtUser.text}",Toast.LENGTH_SHORT).show()
        //Toast.makeText(this,"En la variable ${binding.user?.name}",Toast.LENGTH_SHORT).show()
            if (viewModel.login()) {
                val preferences: SharedPreferences =
                    getSharedPreferences("unabApp.pref", MODE_PRIVATE)
                val editor: SharedPreferences.Editor = preferences.edit()
                editor.putBoolean("login", true)
                editor.apply()
                Toast.makeText(this, "Iniciando sesion....", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Login inválido", Toast.LENGTH_SHORT).show()
            }
        }

        binding.LoginBtSingup.setOnClickListener {
            startActivity(Intent(applicationContext, FormActivity::class.java))
        }
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