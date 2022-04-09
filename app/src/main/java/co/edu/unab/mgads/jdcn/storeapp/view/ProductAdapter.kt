package co.edu.unab.mgads.jdcn.storeapp.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import co.edu.unab.mgads.jdcn.storeapp.R
import co.edu.unab.mgads.jdcn.storeapp.databinding.ProductItemBinding
import co.edu.unab.mgads.jdcn.storeapp.model.Product

class ProductAdapter(private var products:ArrayList<Product>):RecyclerView.Adapter<ProductAdapter.ProductViewHolder>(){

    var onItemClickListener:((Product)->Unit)?=null

    fun refresh(myProduct: ArrayList<Product>){
        products=myProduct
        notifyDataSetChanged()
    }

    class ProductViewHolder(private  val binding: ProductItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(myProduct: Product, onItemClickListener: ((Product) -> Unit)?){
            binding.product=myProduct

            binding.root.setOnClickListener{
                onItemClickListener?.let {
                    it(myProduct)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val inflate=LayoutInflater.from(parent.context)
        val binding:ProductItemBinding = DataBindingUtil.inflate(inflate,
            R.layout.product_item,parent,false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(products[position], onItemClickListener)
    }

    override fun getItemCount(): Int= products.size
}