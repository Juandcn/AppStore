package co.edu.unab.mgads.jdcn.storeapp.view

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import co.edu.unab.mgads.jdcn.storeapp.R
import co.edu.unab.mgads.jdcn.storeapp.databinding.ActivityProductAddBinding
import co.edu.unab.mgads.jdcn.storeapp.model.entity.Product
import co.edu.unab.mgads.jdcn.storeapp.viewModel.ProductAddActivityViewModel
import com.bumptech.glide.Glide
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*


class ProductAddActivity : AppCompatActivity() {

    lateinit var binding:ActivityProductAddBinding
    lateinit var viewModel:ProductAddActivityViewModel
    lateinit var resultGallery: ActivityResultLauncher<Intent>
    lateinit var resultCamera: ActivityResultLauncher<Intent>
    var photoUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var bundle:Bundle? = intent.extras
        title=bundle?.getString("title")

        var myProduct:Product?=intent.getSerializableExtra("product") as Product?
        binding=DataBindingUtil.setContentView(this,R.layout.activity_product_add)
        viewModel=ViewModelProvider(this)[ProductAddActivityViewModel::class.java]
        //binding.viewModel=viewModel
        binding.product = myProduct

        myProduct?.let {
            binding.FormTvTitleAddproduct.text = "Editar ${it.name}"
            //viewModel.product=it
            binding.FormBtRegister.text = "Editar Producto"
            binding.FormBtRegister.setOnClickListener {
                viewModel.update(binding.product as Product).observe(this) { state ->
                    if (state) {
                        finish()
                    } else {
                        Toast.makeText(
                            applicationContext, "Problema al modificar el producto",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        } ?: run {
            myProduct = Product()
            binding.FormBtRegister.setOnClickListener {
                viewModel.add(binding.product as Product, photoUri).observe(this) { id ->
                    binding.FormBtRegister.isEnabled = true
                    if (id != "") {
                        finish()
                    } else {
                        Toast
                            .makeText(
                                applicationContext, "Problema al agregar el producto",
                                Toast.LENGTH_SHORT
                            )
                            .show()
                }
            }
        }

            binding.product = myProduct

            resultGallery =registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                    if (it.resultCode == RESULT_OK) run {
                        photoUri = it.data!!.data!!
                        Glide.with(applicationContext).load(photoUri).into(binding.FormImImagenAddproduct)
                    }
                }

            resultCamera =
                registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                    if (it.resultCode == RESULT_OK) run {
                        Glide.with(applicationContext).load(photoUri).into(binding.FormImImagenAddproduct)
                    }
                }

            binding.FormBtReturn.setOnClickListener {
                //finish()
            }

            binding.FormImImagenGalleryAddproduct.setOnClickListener {
                val galleryItem =
                    Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                resultGallery.launch(galleryItem)
            }

            binding.FormImImagenCameraAddproduct.setOnClickListener {
                val cameraItem = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                var photoFile: File? = null
                try {
                    photoFile = createImage()
                } catch (e: IOException) {
                }

                photoFile?.let {
                    photoUri = FileProvider.getUriForFile(
                        applicationContext,
                        "com.sebastianjoya.unabapp.fileprovider",
                        photoFile
                    )
                    cameraItem.putExtra(MediaStore.EXTRA_OUTPUT, photoUri)
                    resultCamera.launch(cameraItem)
                }
            }
        }
    }

    private fun createImage(): File? {
        var timeStamp = SimpleDateFormat("yyyy-MM-dd-HHmmss", Locale.US).format(Date())
        val storeAppDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES)

        return File.createTempFile(timeStamp, ".jpg",storeAppDir)
    }
}