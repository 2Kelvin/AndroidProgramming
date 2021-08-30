package com.r19.mywebviewapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    //initializing variables
    var btnMove:Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //getting buttons by id
        btnMove = findViewById(R.id.btnMove)
        //setting an event handler
        btnMove!!.setOnClickListener {
            //intent acts like html's <a> tag => will take you to myWebActivity
            var visit = Intent(this,myWebActivity::class.java)
            startActivity(visit)
        }
    }
}