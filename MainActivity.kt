package com.r19.mylistandspinnerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Spinner
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var myPeopleList:ListView? = null
    var myPrivilegeSpinner:Spinner? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myPeopleList = findViewById(R.id.myListStudents)
        myPrivilegeSpinner = findViewById(R.id.spinnerPrivileges)
        myPeopleList!!.setOnItemClickListener { parent, view, position, id ->
            var name = parent.getItemAtPosition(position).toString()
            Toast.makeText(applicationContext, "You tapped on " + name, Toast.LENGTH_LONG).show()
        }
        myPrivilegeSpinner?.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                //do something here
                var selectedPrivilege = parent!!.getItemAtPosition(position).toString()
                Toast.makeText(applicationContext, "You selected " +selectedPrivilege, Toast.LENGTH_LONG).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                //do something here
            }
        }
    }
}