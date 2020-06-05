package com.example.daggermitchdemo.ui.main

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.daggermitchdemo.BaseActivity
import com.example.daggermitchdemo.R

/**
 *Created by Ankit Bajaj on 05-06-2020.
 */
class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("My Main Activity", "Welcome to MainActivity")
        Toast.makeText(this, "Welcome Main Activity", Toast.LENGTH_LONG).show()
    }
}