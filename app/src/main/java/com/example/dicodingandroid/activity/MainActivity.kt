package com.example.dicodingandroid.activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts
import com.example.dicodingandroid.Person
import com.example.dicodingandroid.R


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var tvResult: TextView
    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == MoveWithResult.RESULT_CODE && result.data != null) {
            val selectedValue =
                result.data?.getIntExtra(MoveWithResult.EXTRA_SELECTED_VALUE, 0)
            tvResult.text = "Hasil : $selectedValue"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMove: Button = findViewById(R.id.btn_move_activity)
        btnMove.setOnClickListener(this)
        val btnMoveWithData: Button = findViewById(R.id.btn_move_activity_data)
        btnMoveWithData.setOnClickListener(this)
        val btnMoveWithObject: Button = findViewById(R.id.btn_move_activity_obj)
        btnMoveWithObject.setOnClickListener(this)
        val btnDialNumber: Button = findViewById(R.id.btn_dial_number)
        btnDialNumber.setOnClickListener(this)
        val btnMoveToResult: Button = findViewById(R.id.btn_move_for_result)
        btnMoveToResult.setOnClickListener(this)
        tvResult = findViewById(R.id.tv_result)

        val btnMoveToFragment: Button = findViewById(R.id.btn_move_to_fragment)
        btnMoveToFragment.setOnClickListener(this)
        val btnMoveToLayout: Button = findViewById(R.id.btn_move_to_layouting)
        btnMoveToLayout.setOnClickListener(this)
        val btnMoveToCustomComponent: Button = findViewById(R.id.btn_move_to_customComponent)
        btnMoveToCustomComponent.setOnClickListener(this)
        val btnMoveToRecyclerView: Button = findViewById(R.id.btn_move_to_recycleView)
        btnMoveToRecyclerView.setOnClickListener(this)
        val btnMoveToApplyLib: Button = findViewById(R.id.btn_to_using_library)
        btnMoveToApplyLib.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_move_activity -> {
                val moveInt = Intent(this, MoveActivity::class.java)
                startActivity(moveInt)
            }
            R.id.btn_move_activity_data -> {
                val moveIntData = Intent(this, MoveWithDataActivity::class.java)
                val reqName = "Albert"
                val reqAge = 30
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
            R.id.btn_dial_number -> {
                val phoneNumber = "081260932766"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }
            R.id.btn_move_for_result -> {
                val moveForResultIntent = Intent(this, MoveWithResult::class.java)
                resultLauncher.launch(moveForResultIntent)
            }
            R.id.btn_move_to_fragment -> {
                val moveToFragment = Intent(this, FragmentPractice::class.java)
                startActivity(moveToFragment)
            }
            R.id.btn_move_to_layouting -> {
                val moveToLayout = Intent(this, LayoutingActivity::class.java)
                startActivity(moveToLayout)
            }
            R.id.btn_move_to_constraintLayout -> {
                val moveToCLayout = Intent(this, ConstraintLayoutActivity::class.java)
                startActivity(moveToCLayout)
            }
            R.id.btn_move_to_customComponent -> {
                val moveToCLayout = Intent(this, CustomComponentActivity::class.java)
                startActivity(moveToCLayout)
            }
            R.id.btn_move_to_recycleView -> {
                val moveToCLayout = Intent(this, RecyclerViewActivity::class.java)
                startActivity(moveToCLayout)
            }
            R.id.btn_to_using_library -> {
                val moveToCLayout = Intent(this, ApplyLibraryActivity::class.java)
                startActivity(moveToCLayout)
            }
        }
    }

}