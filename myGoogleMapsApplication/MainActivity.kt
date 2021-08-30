package com.r19.mygooglemapsapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    //initiating a variable for the maps button
    var btnMaps:Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //'getting' the maps button by id
        btnMaps = findViewById(R.id.btnMaps)

        //setting an event handler when button maps is clicked
        //opens a new link of the maps
        btnMaps!!.setOnClickListener {
            var mapLink = Intent(this,MapsActivity::class.java)
            startActivity(mapLink)
        }
    }
}

//created a new file in 'com.r19.mygooglemapsapplication' => google; google maps
//created a map activity and a google_maps.xml
//in the google_maps.xml add the API key you get from Google Cloud Platform