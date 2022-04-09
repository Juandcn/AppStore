package co.edu.unab.mgads.jdcn.storeapp.viewModel

import androidx.lifecycle.ViewModel
import co.edu.unab.mgads.jdcn.storeapp.model.entity.Product

class ProductDetailActivityViewModel:ViewModel() {
    var product= Product(name="",price=0)
}