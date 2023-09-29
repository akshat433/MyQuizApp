package com.example.myquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        var tvName : TextView = findViewById(R.id.tv_name)
        var tvScore : TextView = findViewById(R.id.tv_score)
        var btnFinish : Button = findViewById(R.id.btn_finish)

        tvName.text =intent.getStringExtra(Constant.User_Name)

        val totalQuestion = intent.getIntExtra(Constant.Total_Question,0)
        val CorrectAnswer = intent.getIntExtra(Constant.Correct_Answers,0)

        tvScore.text = "Your Score Out of $CorrectAnswer / $totalQuestion"

        btnFinish.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}