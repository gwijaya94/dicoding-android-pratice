package com.example.dicodingandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMove: Button = findViewById(R.id.btn_move_activity)
        btnMove.setOnClickListener(this)
        val btnMoveWithData: Button = findViewById(R.id.btn_move_activity_data)
        btnMoveWithData.setOnClickListener(this)
        val btnMoveWithObject: Button = findViewById(R.id.btn_move_activity_obj)
        btnMoveWithObject.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_move_activity -> {
                val moveInt = Intent(this, MoveActivity::class.java)
                startActivity(moveInt)
            }
            R.id.btn_move_activity_data -> {
                val moveIntData = Intent(this, MoveWithDataActivity::class.java)
                var reqName = "Albert"
                var reqAge = 30
                moveIntData.putExtra(MoveWithDataActivity.EXTRA_NAME, reqName)
                moveIntData.putExtra(MoveWithDataActivity.EXTRA_AGE, reqAge)
                startActivity(moveIntData)
            }
            R.id.btn_move_activity_obj -> {
                val personObj = Person(
                    "DicodingAcademy",
                    5,
                    "academy@dicoding.com",
                    "Bandung"
                )
                val moveWithObjectIntent = Intent(this, MoveObjectActivity::class.java)
                moveWithObjectIntent.putExtra(MoveObjectActivity.EXTRA_PERSON, personObj)
                startActivity(moveWithObjectIntent)
            }
        }
    }

}