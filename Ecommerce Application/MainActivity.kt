package com.r19.ecommerceapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    var products:ArrayList<product>? = null
    var productList:ListView? = null
    var adapter:CustomAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        productList = findViewById(R.id.productList)
        products = ArrayList()
        adapter = CustomAdapter(this,products!!)

        //these are the items being displayed
        var item1 = product(R.drawable.air, "Air Jordans One", "First Jumpmans", "Ksh 9,500")
        var item2 = product(R.drawable.nike, "Nike one", "Nike one", "Ksh 5,500")
        var item3 = product(R.drawable.nikeee, "Nike two", "Nike two", "Ksh 8,000")

        //adding the items to the array list
        products!!.add(item1)
        products!!.add(item2)
        products!!.add(item3)

        //setting the adapter to the listView
        productList!!.adapter = adapter
    }
}