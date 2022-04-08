package co.edu.unab.mgads.jdcn.storeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class KotlinActivity : AppCompatActivity() {

    lateinit var urlImage:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Ejemplo de declaracion de Variables - Constantes Kotlin
        val name: String = "Juan"
        val heigt: Double = 1.75
        val age: Int = 28
        val admin: Boolean = true

        //Ejemplo Impresion de Variables - Constantes Kotlin
        println("$name Altura $heigt, Edad $age es administrador $admin")

        //Ejemplo de declaracion de Estructuras de Control Kotlin
        val email: String = getString(R.string.Login_user)
        val emailInput = "Juan@coreo"
        val pass: String = getString(R.string.Login_pass)
        val passInput = "12345"

        //Estructuras de Control IF Kotlin
        if (email == emailInput && pass == passInput) {
            println("Iniciando Sesion...")
        } else if (email != emailInput) {
            println("Correo Invalido...")
        } else {
            println("Datos Invalidos...")
        }

        //Estructuras de Control WHEN Kotlin
        val typeUser = 1
        when (typeUser) {
            1 -> {
                println("Administador...")
            }
            in 2..4 -> {
                println("Cliente...")
            }
            else -> {
                println("Invitado...")
            }
        }

        //Ejemplo de declaracion de Estructuras de Datos Kotlin
        val product: ArrayList<String> = arrayListOf("Monitor", "Teclado", "Mouse")
        println(product)

        //Ejemplo de declaracion de Mapas de Datos Kotlin
        val monitor = mutableMapOf<String, Any>("name" to "Monitor")

        monitor["price"] = 70000
        monitor["amount"] = 75
        println(monitor)
        monitor["price"] = 80000

        for ((Key,Value) in monitor){
            print("$Key -$Value")
        }

        val monitorMap = monitor[name]
        monitor.remove("amount")

        //Ejemplo de declaracion de NULLSAFETY Kotlin
        var testNull: String? = null

        //Ejemplo de llamado de funciones Kotlin
        loadProducts()
        showProducts("Disco Duro", 250000)
        showProducts(price=750000, name="Portatil")

        //Ejemplo de llamado de CLASES Kotlin
        val portatil:Product = Product("Portatil Asus",5000000, "No Aplica", ProductStatus.AVAILABLE)
        val portatil2:Product = Product("Portatil Asus",5000000, "No Aplica", ProductStatus.AVAILABLE)
        val result:Boolean = portatil===portatil2
        val(n,p,d,s)=portatil

        val myClient:User= Client(name="juan Celis", password="123456789", document = "1090477444", urlpic = "www.foto.com", email = "juan@correo.com")
        if (myClient is Client){
        }

        clickListener {
           println(it)
           true
        }
    }

    //Ejemplo de declaracion de funciones Kotlin
    fun loadProducts(): Unit {
    //Obtener los productos
    }

    fun showProducts(name: String, price: Int): Unit {
       print("El producto $name tiene un valor $price")
    }

    fun login(email:String, password:String):Boolean{
        return email==getString(R.string.Login_user) && password==getString(R.string.Login_pass)
    }

    fun clickListener (Click:(String)->Boolean){
        print("Hola")
    }
}