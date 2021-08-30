package com.r19.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initializing variables for the input boxes
        var firstNo:EditText = findViewById(R.id.firstNum)
        var secondNo:EditText = findViewById(R.id.secondNumber)
        var myAnswer:TextView = findViewById(R.id.answer)

        //grabbing the buttons by id
        var add:Button = findViewById(R.id.btnAdd)
        add.setOnClickListener {
            //getting the data from the input boxes
            var fNumber = firstNo.text.toString().trim() //.text gets the values in the first input box //try using getText() see if it works
            var sNumber = secondNo.text.toString().trim() //.text gets the values in the second input box //try using getText() see if it works

            if (fNumber.isEmpty()){
                //cancelling button working if there's no data filled in the first input box
                firstNo.setError("Please fill this input")
                firstNo.requestFocus()
            }else if (sNumber.isEmpty()) {
                //cancelling button working if there's no data filled in the second input box
                secondNo.setError("Please fill this input")
                secondNo.requestFocus()
            }else {
                //continue with the calculation
                    //converting the string data to integers(double)
                var calcFNumber = fNumber.toDouble()
                var calcSNumber = sNumber.toDouble()
                var calcAnswer = calcFNumber + calcSNumber
                myAnswer.text = calcAnswer.toString()
                //.text means answer is displayed on the UI
            }
        }

        var subtract:Button = findViewById(R.id.btnSubtract)
        subtract.setOnClickListener {
            //getting the data from the input boxes
            var fNumber = firstNo.text.toString().trim() //.text gets the values in the first input box
            var sNumber = secondNo.text.toString().trim() //.text gets the values in the second input box

            if (fNumber.isEmpty()){
                //cancelling button working if there's no data filled in the first input box
                firstNo.setError("Please fill this input")
                firstNo.requestFocus()
            }else if (sNumber.isEmpty()) {
                //cancelling button working if there's no data filled in the second input box
                secondNo.setError("Please fill this input")
                secondNo.requestFocus()
            }else {
                //continue with the calculation
                //converting the string data to integers(double)
                var calcFNumber = fNumber.toDouble()
                var calcSNumber = sNumber.toDouble()
                var calcAnswer = calcFNumber - calcSNumber
                myAnswer.text = calcAnswer.toString()
                //.text means answer is displayed on the UI
            }
        }

        var divide:Button = findViewById(R.id.btnDivide)
        divide.setOnClickListener {
            //getting the data from the input boxes
            var fNumber = firstNo.text.toString().trim() //.text gets the values in the first input box
            var sNumber = secondNo.text.toString().trim() //.text gets the values in the second input box

            if (fNumber.isEmpty()){
                //cancelling button working if there's no data filled in the first input box
                firstNo.setError("Please fill this input")
                firstNo.requestFocus()
            }else if (sNumber.isEmpty()) {
                //cancelling button working if there's no data filled in the second input box
                secondNo.setError("Please fill this input")
                secondNo.requestFocus()
            }else {
                //continue with the calculation
                //converting the string data to integers(double)
                var calcFNumber = fNumber.toDouble()
                var calcSNumber = sNumber.toDouble()
                var calcAnswer = calcFNumber / calcSNumber
                myAnswer.text = calcAnswer.toString()
                //.text means answer is displayed on the UI
            }
        }

        var multiply:Button = findViewById(R.id.btnMultiply)
        multiply.setOnClickListener {
            //getting the data from the input boxes
            var fNumber = firstNo.text.toString().trim() //.text gets the values in the first input box
            var sNumber = secondNo.text.toString().trim() //.text gets the values in the second input box

            if (fNumber.isEmpty()){
                //cancelling button working if there's no data filled in the first input box
                firstNo.setError("Please fill this input")
                firstNo.requestFocus()
            }else if (sNumber.isEmpty()) {
                //cancelling button working if there's no data filled in the second input box
                secondNo.setError("Please fill this input")
                secondNo.requestFocus()
            }else {
                //continue with the calculation
                //converting the string data to integers(double)
                var calcFNumber = fNumber.toDouble()
                var calcSNumber = sNumber.toDouble()
                var calcAnswer = calcFNumber * calcSNumber
                myAnswer.text = calcAnswer.toString()
                //.text means answer is displayed on the UI
            }
        }
    }
}