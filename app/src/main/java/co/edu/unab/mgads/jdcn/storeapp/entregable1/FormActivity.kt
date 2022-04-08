package co.edu.unab.mgads.jdcn.storeapp.entregable1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        setContentView(R.layout.activity_form)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_form)
        viewModel= ViewModelProvider(this)[FormActivityVievModel::class.java]

        binding.viewModel=viewModel
        binding.FormBtRegister.setOnClickListener {
            var text=viewModel.registro()
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
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