package com.r19.mywebviewapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView

class myWebActivity : AppCompatActivity() {

    //initializing a webView variable
    var myWebView:WebView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_web)

        myWebView = findViewById(R.id.myWebsite)
        var mySettings:WebSettings = myWebView!!.settings
        mySettings.javaScriptEnabled
        myWebView!!.loadUrl("file:///android_asset/home.html")
    }
}