package com.r19.firebaseapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    //initializing variables
    var name:EditText? = null
    var email:EditText? = null
    var IDNo:EditText? = null
    var btnSave:Button? = null
    var btnView:Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //finding editTexts and buttons by ID
        name = findViewById(R.id.name)
        email = findViewById(R.id.email)
        IDNo = findViewById(R.id.IDNo)
        btnSave = findViewById(R.id.btnSave)
        btnView = findViewById(R.id.btnView)

        //onClickListeners for the buttons; btnSave and btnView
        btnSave!!.setOnClickListener {
            var name = name!!.text.toString().trim()
            var email = email!!.text.toString().trim()
            var IDNo = IDNo!!.text.toString().trim()

            //checking if the user has filled all the input
            if (name.isEmpty() || email.isEmpty() || IDNo.isEmpty()) {
                Toast.makeText(this, "Please fill all the inputs", Toast.LENGTH_LONG).show()
            }else {
                //continue to save data
                var time = System.currentTimeMillis().toString()
                //preparing user data to be saved
                var users = user(name, email, IDNo, time)
                //creating a table/child
                var ref:DatabaseReference = FirebaseDatabase.getInstance().getReference().child("users/$time")
                //storing data on the reference and checking if the data was saved
                ref.setValue(users).addOnCompleteListener { task ->
                    if (task.isComplete) {
                        Toast.makeText(this, "User saved successfully", Toast.LENGTH_LONG).show()
                    }else {
                        Toast.makeText(this, "Saving user failed", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }

        btnView!!.setOnClickListener {
            var link = Intent(this,viewUsers::class.java)
            startActivity(link)
        }
    }
}