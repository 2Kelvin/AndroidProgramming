package com.r19.sqlitedatabaseapplication

import android.content.Context
import android.content.DialogInterface
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    //initializing variables
    var name:EditText? = null
    var email:EditText? = null
    var IDNo:EditText? = null
    var btnSave:Button? = null
    var btnView:Button? = null
    var btnDelete:Button? = null
    var btnUpdate:Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //getting buttons and editTexts by Id
        name = findViewById(R.id.name)
        email = findViewById(R.id.email)
        IDNo = findViewById(R.id.IDNo)
        btnSave = findViewById(R.id.btnSave)
        btnView = findViewById(R.id.btnView)
        btnDelete = findViewById(R.id.btnDelete)
        btnUpdate = findViewById(R.id.btnUpdate)

        //creating an SQL database
        var myDatabase:SQLiteDatabase = openOrCreateDatabase("registrations", Context.MODE_PRIVATE, null)

        //creating a table that stores the users details -> table is called users
        myDatabase.execSQL("CREATE TABLE IF NOT EXISTS users(names VARCHAR, emails VARCHAR, IDS varchar)")

        //event handler code on button save when clicked
        btnSave!!.setOnClickListener {
            //receiving content from the editTexts
            var name = name!!.text.toString().trim()
            var email = email!!.text.toString().trim()
            var IDNo = IDNo!!.text.toString().trim()
            //checking if the user is trying to submit empty fields
            if (name.isEmpty() || email.isEmpty() || IDNo.isEmpty()) {
                //calling the messages function
                messages("ERROR!", "Please fill all the fields")
            } else {
                //proceed to save the data(name, email, ID number) in my SQLite database
                myDatabase.execSQL("INSERT INTO users VALUES('"+name+"','"+email+"','"+IDNo+"')")
                //displaying message (user successfully registered)
                messages("SUCCESS!", "User saved successfully")
                //clearing the input fields after successful save
                clear()
            }
        }

        //event handler for when button view is clicked
        btnView!!.setOnClickListener {
            //using a cursor to select data from myDatabase
            var cursor = myDatabase.rawQuery("SELECT * FROM users", null)
            if (cursor.count == 0) {
                messages("NO RECORDS FOUND", "Sorry, no records found")
            } else {
                //using the buffer to append the records to be displayed
                var buffer = StringBuffer()
                while (cursor.moveToNext()) {
                    buffer.append(cursor.getString(0)+"\n")
                    buffer.append(cursor.getString(1)+"\n")
                    buffer.append(cursor.getString(2)+"\n\n")
                }
                messages("DB RECORDS", buffer.toString())
            }
        }

        //event handler for when button delete is clicked
        btnDelete!!.setOnClickListener {
            var IDNo = IDNo!!.text.toString().trim()
            if (IDNo.isEmpty()) {
                messages("EMPTY FIELD", "Please enter your ID number")
            }else {
                //using the cursor to select the user with the given ID
                var cursor = myDatabase.rawQuery("SELECT FROM users WHERE emails='"+IDNo+"'",null)
                //checking if the record is available in the database
                if (cursor.count == 0) {
                    messages("NO RECORDS!!", "Sorry, no records found")
                }else {
                    //proceed to delete the record
                    myDatabase.execSQL("DELETE FROM users WHERE emails='"+IDNo+"'")
                    messages("SUCCESS!!", "Record deleted successfully")
                    clear()
                }
            }
        }
    }

    //FUNCTIONS

    //clears data from all editTexts input fields in the UI(name, email, ID number)
    private fun clear() {
        name!!.setText("")
        email!!.setText("")
        IDNo!!.setText("")
    }

    //displays messages in the UI; if code is successful or has failed ||alert dialogue in the UI
    private fun messages(title:String, message:String) {
        var alertDialog: AlertDialog.Builder = AlertDialog.Builder(this)
        alertDialog.setTitle(title)
        alertDialog.setMessage(message)
        alertDialog.setPositiveButton("Ok", DialogInterface.OnClickListener { dialogInterface, i ->

        })
        alertDialog.create().show()
    }
}
