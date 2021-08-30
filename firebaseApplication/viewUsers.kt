package com.r19.firebaseapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import com.google.firebase.database.*

class viewUsers : AppCompatActivity() {

    var usersList:ListView? = null
    var users:ArrayList<user>? = null
    var adapter:CustomAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_users)

        usersList = findViewById(R.id.usersList)
        users = ArrayList()
        adapter = CustomAdapter(this, users!!)

        //Making the reference to the database
        var reference:DatabaseReference = FirebaseDatabase.getInstance().getReference().child("users")

        //fetching the data
        reference.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                users!!.clear()

                //looping through fetched data and displaying it
                for (snap in snapshot.children) {
                    var user = snap.getValue(user::class.java)
                    users!!.add(user!!)
                }
                adapter!!.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@viewUsers, "Please contact ADMIN for assistance", Toast.LENGTH_LONG)
            }
        })
        usersList!!.adapter = adapter
    }
}