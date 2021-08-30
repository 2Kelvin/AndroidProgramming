package com.r19.myintentsapplication

import android.Manifest
import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import org.jetbrains.anko.email
import org.jetbrains.anko.makeCall
import org.jetbrains.anko.sendSMS
import org.jetbrains.anko.share

class MainActivity : AppCompatActivity() {

    //initializing variables for the buttons
    var btnCall:Button? = null
    var btnSms:Button? = null
    var btnShare:Button? = null
    var btnDial:Button? = null
    var btnEmail:Button? = null
    var mpesa:Button? = null
    var camera:Button? = null
    var camPic:ImageView? = null

    //capturing an image
    private val PERMISSION_CODE = 1000
    private val IMAGE_CAPTURE_CODE = 1001
    var image_uri: Uri? = null //ALT + ENTER to import

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //getting buttons by id
        btnCall = findViewById(R.id.btnCall)
        btnSms = findViewById(R.id.btnSms)
        btnShare = findViewById(R.id.btnShare)
        btnDial = findViewById(R.id.btnDial)
        btnEmail = findViewById(R.id.btnEmail)
        mpesa = findViewById(R.id.mpesa)
        camera = findViewById(R.id.camera)
        camPic = findViewById(R.id.camPic)

        //setting code('event handlers') for what happens when the buttons are clicked
            //bit.ly/3iBJs11 (github link for custom functions to use); add to implements to manifest then sync
                //for any 'red highlighted' functions/variables, click them then press ALT + ENTER to import them
        btnCall!!.setOnClickListener {
            makeCall("0726223593")
        }

        btnSms!!.setOnClickListener {
            sendSMS("0726223593", "Hi")
        }

        btnShare!!.setOnClickListener {
            share("I've got a new app! Please check it out")
        }

        btnDial!!.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + Uri.encode("+254")))
            startActivity(intent)
        }

        btnEmail!!.setOnClickListener {
            email("kevin.art.ion@gmail.com", "APP DEVELOPMENT", "Congrats on your new mobile app!")
        }

        mpesa!!.setOnClickListener {
            val simToolKitLaunchIntent: Intent? =
                this@MainActivity.getPackageManager().getLaunchIntentForPackage("com.android.stk")
            simToolKitLaunchIntent?.let { startActivity(it) }
        }

        camera!!.setOnClickListener {
            //if system os is Marshmallow or Above, we need to request runtime permission
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                if (checkSelfPermission(Manifest.permission.CAMERA)
                    == PackageManager.PERMISSION_DENIED ||
                    checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_DENIED){
                    //permission was not enabled
                    val permission = arrayOf(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    //show popup to request permission
                    requestPermissions(permission, PERMISSION_CODE)
                }
                else{
                    //permission already granted
                    openCamera()
                }
            }
            else{
                //system os is < marshmallow
                openCamera()
            }

        }
    }

    //Function to open camera
    private fun openCamera() {
        val values = ContentValues()
        values.put(MediaStore.Images.Media.TITLE, "New Picture")
        values.put(MediaStore.Images.Media.DESCRIPTION, "From the Camera")
        image_uri = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)
        //camera intent
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, image_uri)
        startActivityForResult(cameraIntent, IMAGE_CAPTURE_CODE)
    }

    //Requesting permission from the user
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        //called when user presses ALLOW or DENY from Permission Request Popup
        when(requestCode){
            PERMISSION_CODE -> {
                if (grantResults.size > 0 && grantResults[0] ==
                    PackageManager.PERMISSION_GRANTED){
                    //permission from popup was granted
                    openCamera()
                }
                else{
                    //permission from popup was denied
                    Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    //setting the image on the imageview
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        //called when image was captured from camera intent
        if (resultCode == Activity.RESULT_OK){
            //set image captured to image view
            camPic!!.setImageURI(image_uri)
        }
    }
}