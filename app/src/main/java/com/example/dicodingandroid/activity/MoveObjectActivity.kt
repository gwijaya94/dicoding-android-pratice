package com.example.dicodingandroid.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.dicodingandroid.Person
import com.example.dicodingandroid.R

class MoveObjectActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_PERSON = "extra_person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_object)

        val tvObj: TextView = findViewById(R.id.tv_obj_received)

        val person = intent.getParcelableExtra<Person>(EXTRA_PERSON) as Person
//        val text = "Name : ${person.name.toString()},\nEmail : ${person.email},\nAge : ${person.age},\nLocation : ${person.city}"

        val text =
            """
        Name : ${person.name.toString()},
        Email : ${person.email},
        Age : ${person.age},
        Location : ${person.city}
        """
        tvObj.text = text
    }
}