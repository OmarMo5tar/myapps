
//package com.example.shoppingcart
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.widget.Button
//import android.widget.EditText
//import com.google.firebase.database.FirebaseDatabase
//
//class addProduct : AppCompatActivity() {
//
//    lateinit var pro_name:EditText
//    lateinit var pro_price:EditText
//    lateinit var addBtn:Button
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_add_product)
//
//        pro_name=findViewById(R.id.pro_name)
//        pro_price=findViewById(R.id.pro_price)
//        addBtn=findViewById(R.id.addBtn)
//
//        addBtn.setOnClickListener{
//            savePro();
//
//        }
//
//
//
//    }
//
//    private fun savePro() {
//        val db = FirebaseDatabase.getInstance().getReference("Product")
//        val proName = pro_name.text.toString().trim()
//        val proPrice = pro_price.text.toString().trim()
//        val id = db.push().key
//
//
//        val product = Product(id,name,price)
//
//        if (id != null) {
//            db.child(id).setValue(product)
//        }
//
//    }
//
//
//}
