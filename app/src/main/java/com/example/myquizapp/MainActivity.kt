package com.example.myquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart : Button = findViewById(R.id.btn_start)
        val etName : EditText = findViewById(R.id.et_name)//Name of user
        btnStart.setOnClickListener{


            if(etName.text.isEmpty())
            {
                Toast.makeText(this,
                    "Please Enter your Name",Toast.LENGTH_LONG).show()
            }
            else
            {
                val intent = Intent(this,QuizQuestionsActivity::class.java)
                intent.putExtra(Constant.User_Name,etName.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}