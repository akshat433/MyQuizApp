package com.example.myquizapp

object Constant {

    const val User_Name : String = "user_name"
    const val Total_Question : String = "total_user"
    const val Correct_Answers : String = "correct_answers"



    fun getQuestion():ArrayList<Question>{
        val questionlist = ArrayList<Question>()
        val que1 = Question(
            1,"What country this flag belongs to ?",
            R.drawable.ic_flag_of_argentina,
            "Argentina",
            "Australia",
            "Armenia",
            "Austria",
            1)
        questionlist.add(que1)

        val que2 = Question(
            1,"What country this flag belongs to ?",
            R.drawable.ic_flag_of_australia,
            "Argentina",
            "Australia",
            "Armenia",
            "Austria",
            2)
        questionlist.add(que2)

        val que3 = Question(
            1,"What country this flag belongs to ?",
            R.drawable.ic_flag_of_belgium,
            "Argentina",
            "Australia",
            "Belgium",
            "Brazil",
            3)
        questionlist.add(que3)

        val que4 = Question(
            1,"What country this flag belongs to ?",
            R.drawable.ic_flag_of_brazil,
            "Brazil",
            "Australia",
            "Sweden",
            "Denmark",
            1)
        questionlist.add(que4)

        val que5 = Question(
            1,"What country this flag belongs to ?",
            R.drawable.ic_flag_of_denmark,
            "Argentina",
            "Denmark",
            "Australia",
            "Norway",
            2)
        questionlist.add(que5)

        val que6 = Question(
            1,"What country this flag belongs to ?",
            R.drawable.ic_flag_of_fiji,
            "Brazil",
            "Australia",
            "Indonesia",
            "Fiji",
            4)
        questionlist.add(que6)

        val que7 = Question(
            1,"What country this flag belongs to ?",
            R.drawable.ic_flag_of_germany,
            "Belgium",
            "America",
            "Germany",
            "Japan",
            3)
        questionlist.add(que7)

        val que8 = Question(
            1,"What country this flag belongs to ?",
            R.drawable.ic_flag_of_india,
            "India",
            "Nepal",
            "Bangladesh",
            "Afghanistan",
            1)
        questionlist.add(que8)

        val que9 = Question(
            1,"What country this flag belongs to ?",
            R.drawable.ic_flag_of_new_zealand,
            "Britain",
            "Australia",
            "Mauritius",
            "New Zealand",
            4)
        questionlist.add(que9)

        return questionlist
    }
}
