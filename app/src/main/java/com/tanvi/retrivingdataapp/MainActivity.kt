package com.tanvi.retrivingdataapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var textViewResult: TextView
    private lateinit var editTextNumber1: EditText
    private lateinit var editTextNumber2: EditText
    private lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textViewResult = findViewById(R.id.textViewResult)
        editTextNumber1 = findViewById(R.id.editTextNumber1)
        editTextNumber2 = findViewById(R.id.editTextNumber2)
        button = findViewById(R.id.btnOpenActivity2)
        button.setOnClickListener {
            if ((editTextNumber1.text.toString() == "" || editTextNumber2.text.toString() == "")) {
                Toast.makeText(this@MainActivity, "Please insert numbers", Toast.LENGTH_SHORT).show()
            } else {
                val number1 = Integer.parseInt(editTextNumber1.text.toString())
                val number2 = Integer.parseInt(editTextNumber2.text.toString())
                val intent = Intent(this@MainActivity, SecondActivity::class.java)
                intent.putExtra("number1", number1)
                intent.putExtra("number2", number2)
            }
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                val result = data!!.getIntExtra("result", 0)
                textViewResult.text = "" + result
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                textViewResult.text = "Nothing selected"
            }
        }
    }
}

