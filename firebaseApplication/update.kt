package com.r19.firebaseapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class update : AppCompatActivity() {

    //initializing variables
    var editTextName: EditText? = null
    var editTextEmail: EditText? = null
    var editTextIdNumber: EditText? = null
    var buttonUpdate: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        //finding editTexts and buttons by ID
        editTextName = findViewById(R.id.name)
        editTextEmail = findViewById(R.id.email)
        editTextIdNumber = findViewById(R.id.IDNo)
        buttonUpdate = findViewById(R.id.btnUpdate)

        //receiving data from update activity intent
        var receivedName = intent.getStringExtra("x")
        var receivedEmail = intent.getStringExtra("y")
        var receivedIDNo = intent.getStringExtra("z")
        var id = intent.getStringExtra("id")

        //displaying the received values on the textViews, ready to be updated
        editTextName!!.setText(receivedName)
        editTextEmail!!.setText(receivedEmail)
        editTextIdNumber!!.setText(receivedIDNo)

        //setting a listener on button Update to return the updated data to the database
        buttonUpdate!!.setOnClickListener {
            //receiving the updated data
            var nameUpdated = editTextName!!.text.toString().trim()
            var emailUpdated = editTextEmail!!.text.toString().trim()
            var IDNoUpdated = editTextIdNumber!!.text.toString().trim()

            //checking if the user is submitting empty fields
            if (nameUpdated.isEmpty() || emailUpdated.isEmpty() || IDNoUpdated.isEmpty()){
                //displaying message to user to fill all fields
                Toast.makeText(this, "Fill all the inputs", Toast.LENGTH_LONG).show()
            }else {
                //continue to update the new data to the database
                var reference = FirebaseDatabase.getInstance().getReference().child("users/$id")
                var updatedUserData = user(nameUpdated,emailUpdated,IDNoUpdated,id!!)
                reference.setValue(updatedUserData).addOnCompleteListener { task->
                    if (task.isSuccessful){
                        //display message
                        Toast.makeText(this, "Update successful", Toast.LENGTH_LONG).show()
                    }else {
                        //display message
                        Toast.makeText(this, "Update failed", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}