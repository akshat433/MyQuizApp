package com.example.myquizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition : Int = 1
    private var mQuestionList : ArrayList<Question>? = null
    private var mSelectedOptionPosition : Int = 0
    private var mUserName : String? =null
    private var mCorrectAnswer : Int =0

    private var progressBar : ProgressBar?=null
    private var tvProgress :TextView?=null
    private var tvQuestion : TextView?=null
    private var ivImage : ImageView?=null

    private var tvOptionOne : TextView?=null
    private var tvOptionTwo : TextView?=null
    private var tvOptionThree : TextView?=null
    private var tvOptionFour : TextView?=null
    private var btnSubmit : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        //This call the parent constructor
        super.onCreate(savedInstanceState)
        // This is used to align the xml view to this clas
        setContentView(R.layout.activity_quiz_questions)

        mUserName = intent.getStringExtra(Constant.User_Name)

        progressBar = findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.tv_progress)
        tvQuestion = findViewById(R.id.tv_question)
        ivImage = findViewById(R.id.iv_image)

        tvOptionOne = findViewById(R.id.tv_option_one)
        tvOptionTwo = findViewById(R.id.tv_option_two)
        tvOptionThree = findViewById(R.id.tv_option_three)
        tvOptionFour = findViewById(R.id.tv_option_four)
        btnSubmit = findViewById(R.id.btn_submit)

        mQuestionList = Constant.getQuestion()
        setQuestion()


        tvOptionOne?.setOnClickListener(this)
        tvOptionTwo?.setOnClickListener(this)
        tvOptionThree?.setOnClickListener(this)
        tvOptionFour?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)

    }

    private fun setQuestion() {


        val question: Question =
            mQuestionList!![mCurrentPosition - 1]// Getting the question from the list with the help of current position.

        defaultOptionView()

        progressBar?.progress =
            mCurrentPosition// Setting the current progress in the progressbar using the position of question
        tvProgress?.text =
            "$mCurrentPosition/${progressBar?.max}" // Setting up the progress text

        // Now set the current question and the options in the UI
        ivImage?.setImageResource(question.image)
        tvQuestion?.text = question.question
        tvOptionOne?.text = question.optionOne
        tvOptionTwo?.text = question.optionTwo
        tvOptionThree?.text = question.optionThree
        tvOptionFour?.text = question.optionFour

        if(mCurrentPosition == mQuestionList!!.size){
            btnSubmit?.text = "Finish"
        }
        else{
            btnSubmit?.text = "Submit"
        }

    }
    private fun defaultOptionView(){
        val options = ArrayList<TextView>()
        tvOptionOne?.let{
            options.add(0,it)
        }
        tvOptionTwo?.let{
            options.add(1,it)
        }
        tvOptionThree?.let{
            options.add(2,it)
        }
        tvOptionFour?.let{
            options.add(3,it)
        }
        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
//            option.setTextColor(Color.parseColor("#FF8089"))
            option.typeface= Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )

        }
    }
    private fun selectedOptionView(tv: TextView,selectedOptionNum: Int){

        defaultOptionView()

        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))

        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }
    override fun onClick(view: View?) {
        when(view?.id){

            R.id.tv_option_one -> {
                tvOptionOne?.let{
                    selectedOptionView(it,1)
                }

            }

            R.id.tv_option_two -> {
                tvOptionTwo?.let{
                    selectedOptionView(it,2)
                }
            }

            R.id.tv_option_three -> {
                tvOptionThree?.let{
                    selectedOptionView(it,3)
                }
            }

            R.id.tv_option_four -> {

                tvOptionFour?.let{
                    selectedOptionView(it,4)

                }
            }

            R.id.btn_submit -> {

                if (mSelectedOptionPosition == 0) {

                    mCurrentPosition += 1

                    when {

                        mCurrentPosition <= mQuestionList!!.size -> {

                            setQuestion()
                        }

//                      TODO:For getting to result page if the question are finally answer.

                        else -> {

                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constant.User_Name, mUserName)
                            intent.putExtra(Constant.Correct_Answers, mCorrectAnswer)
                            intent.putExtra(Constant.Total_Question,mQuestionList?.size)
                            startActivity(intent)
                            finish()
                        }
                    }

                } else {
                    val question = mQuestionList?.get(mCurrentPosition - 1)

                    // This is to check if the answer is wrong
                    if (question!!.correctAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }
                    else mCorrectAnswer +=1
                    // This is for correct answer
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if (mCurrentPosition == mQuestionList!!.size) {

                        btnSubmit?.text = "Finish"

                    }
                    else {

                        btnSubmit?.text = "Go to next Question"

                    }
                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    // TODO (STEP 3: Create a function for answer view.)
    // START
    /**
     * A function for answer view which is used to highlight the answer is wrong or right.
     */
    private fun answerView(answer:Int,drawableView:Int)
    {

        when(answer){

            1 -> {
                tvOptionOne?.background =ContextCompat.getDrawable(
                    this@QuizQuestionsActivity,
                    drawableView
                )
            }
            2 -> {
                tvOptionTwo?.background =ContextCompat.getDrawable(
                    this@QuizQuestionsActivity,
                    drawableView
                )
            }
            3 -> {
                tvOptionThree?.background =ContextCompat.getDrawable(
                    this@QuizQuestionsActivity,
                    drawableView
                )
            }
            4 -> {
                tvOptionFour?.background =ContextCompat.getDrawable(
                    this@QuizQuestionsActivity,
                    drawableView
                )
            }
        }
    }
}