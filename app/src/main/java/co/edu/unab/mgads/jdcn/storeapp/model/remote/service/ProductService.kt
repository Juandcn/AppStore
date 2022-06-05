package co.edu.unab.mgads.jdcn.storeapp.model.remote.service


import co.edu.unab.mgads.jdcn.storeapp.model.entity.Product
import retrofit2.Call
import retrofit2.http.*

interface ProductService {

    @GET("product.json")
    fun getAll(): Call<Map<String,Product>>

    @GET("product/{pid}.json")
    fun getById(@Path("pid")id:String):Call<Product>

    @POST("product.json")
    fun add(@Body product: Product):Call<Map<String,String>>

    @PUT("product/{pid}.json")
    fun update(@Path("pid") id: String, @Body product: Product): Call<Product>

    @DELETE("product/{pid}.json")
    fun delete(@Path("pid") id: String):Call<Unit>
}