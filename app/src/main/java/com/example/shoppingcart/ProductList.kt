package com.example.shoppingcart

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_add_product.*
import kotlinx.android.synthetic.main.activity_product_info.*
import kotlinx.android.synthetic.main.activity_startup.*
import kotlinx.android.synthetic.main.activity_user_is_in.*
import kotlinx.android.synthetic.main.product_list.*

class ProductList : AppCompatActivity() {

    private lateinit var SMdatabase: FirebaseDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_list)
        SMdatabase = FirebaseDatabase.getInstance()

        searchBtn.setOnClickListener {
            checking()
        }
    }

    var code = ""
    private fun checking() {

        code = productCode.text.toString()

        if (code.isEmpty()) {
            Toast.makeText(this, "Please Fill The Blank Spaces", Toast.LENGTH_SHORT).show()
            return
        } else {
            searchBtn.setOnClickListener {

                val intent = Intent(this, ProductInfo::class.java)
                startActivity(intent)

            }
//            productView()

        }
    }

//    private fun productView() {
//        val rootRef = FirebaseDatabase.getInstance().reference
//        val productRef = rootRef.child("Products").child(code)
//        Toast.makeText(this, "Found", Toast.LENGTH_SHORT).show()
//        val valueEventListener = object : ValueEventListener {
//            override fun onDataChange(dataSnapshot: DataSnapshot) {
//                val productData = dataSnapshot.getValue(Product::class.java)
//                product_name.text=productData!!.name.toString()
//                product_no.text = productData.no.toString()
//                product_price.text = productData.price.toString()
//               Log.d("ProductList", productData.name)
//            }
//
//            override fun onCancelled(databaseError: DatabaseError) {
//                Log.d("ProductList", databaseError.message) //Don't ignore errors!
//            }
//        }
//        productRef.addListenerForSingleValueEvent(valueEventListener)
//
//
//    }
    }

