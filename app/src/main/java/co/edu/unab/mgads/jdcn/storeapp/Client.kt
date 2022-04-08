package co.edu.unab.mgads.jdcn.storeapp

class Client(cart:ArrayList<Product>?= arrayListOf(), name: String, password: String, email: String,
             urlpic: String, document:String ): User(name, password, email, urlpic, document), Shopping {

    /*override fun login(): Boolean {
        return super.login()
    }*/

   /* override fun showInfo() {
        TODO("Not yet implemented")
    }*/

    override fun buy() {
        TODO("Not yet implemented")
    }

    override fun getData() {
        TODO("Not yet implemented")
    }
}