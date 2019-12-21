package com.example.shoppingcart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_product_info.*

class ProductInfo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_info)
        productView()
    }

    var code = ""
    private fun productView() {
    val rootRef = FirebaseDatabase.getInstance().reference
    val productRef = rootRef.child("Products").child(code)
    val valueEventListener = object : ValueEventListener {
        override fun onDataChange(dataSnapshot: DataSnapshot) {
            val productData = dataSnapshot.getValue(Product::class.java)
            product_name.text=productData!!.name
            product_no.text = productData.no.toString()
            product_price.text = productData.price.toString()
            Log.d("ProductList", productData.name)
        }

        override fun onCancelled(databaseError: DatabaseError) {
            Log.d("ProductList", databaseError.message) //Don't ignore errors!
        }
    }
    productRef.addListenerForSingleValueEvent(valueEventListener)


}
}
