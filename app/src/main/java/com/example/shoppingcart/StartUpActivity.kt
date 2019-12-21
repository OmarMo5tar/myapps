package com.example.shoppingcart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_startup.*

class StartUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_startup)


        btn_Scan_Startup.setOnClickListener {

           val intent = Intent(this,ScannigQrActivity::class.java)
            startActivity(intent)

        }

        to_product_check.setOnClickListener{

            val intent = Intent(this, ProductList::class.java)
            startActivity(intent)

        }

    }
}
