package com.example.dicodingandroid.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dicodingandroid.R

class LayoutingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layouting)
        supportActionBar?.title = "Google Pixel"
    }
}