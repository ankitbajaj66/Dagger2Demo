package com.example.daggermitchdemo.ui.main

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.daggermitchdemo.BaseActivity
import com.example.daggermitchdemo.R
import com.example.daggermitchdemo.ui.main.posts.PostsFragment
import com.example.daggermitchdemo.ui.main.profile.ProfileFragment

/**
 *Created by Ankit Bajaj on 05-06-2020.
 */
class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("My Main Activity", "Welcome to MainActivity")
        Toast.makeText(this, "Welcome Main Activity", Toast.LENGTH_LONG).show()
        testFragment()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.logout -> sessionManager.logout()
        }
        return true
    }

    private fun testFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.main_container, PostsFragment())
            .commit()
    }
}