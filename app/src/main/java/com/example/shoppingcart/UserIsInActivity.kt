package com.example.shoppingcart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_user_is_in.*

class UserIsInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_is_in)
        user_in()

    }
    private fun user_in(){
        val rootRef = FirebaseDatabase.getInstance().reference
        var intent = intent

        val uid = intent.getStringExtra("name")
        Uid_txt.text = uid.toString()
        val uidRef = rootRef.child("Users").child(uid)
        val valueEventListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val user = dataSnapshot.getValue(User::class.java)

                username_Text_View.text = user!!.Name.toString()

            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.d("AccountActivity", databaseError.message) //Don't ignore errors!
            }
        }
        uidRef.addListenerForSingleValueEvent(valueEventListener)

    }

}
