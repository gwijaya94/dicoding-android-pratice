package com.example.dicodingandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class FragmentPractice : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_practice)

        val mFragmentManager = supportFragmentManager
        val mHomeFragment = HomeFragment()
        val fragment1 = mFragmentManager.findFragmentByTag(HomeFragment::class.java.simpleName)
//Log.i("info",fragment1.toString())
        if (fragment1 !is HomeFragment) {
            Log.d("MyFlexibleFragment", "Fragment Name :" + HomeFragment::class.java.simpleName)
            mFragmentManager
                .beginTransaction()
                .add(R.id.frame_container, mHomeFragment, HomeFragment::class.java.simpleName)
                .commit()
        }
    }
}