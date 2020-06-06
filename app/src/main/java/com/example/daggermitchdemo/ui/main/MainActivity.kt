package com.example.daggermitchdemo.ui.main

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.navigation.navOptions
import androidx.navigation.ui.NavigationUI
import com.example.daggermitchdemo.BaseActivity
import com.example.daggermitchdemo.R
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*


/**
 *Created by Ankit Bajaj on 05-06-2020.
 */
class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("My Main Activity", "Welcome to MainActivity")
        Toast.makeText(this, "Welcome Main Activity", Toast.LENGTH_LONG).show()

        init()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.logout -> sessionManager.logout()
            android.R.id.home -> {
                if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
                    drawer_layout.closeDrawer(GravityCompat.START)
                    return true
                } else {
                    return false
                }
            }
        }
        return true
    }

    private fun init() {
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController, drawer_layout)
        NavigationUI.setupWithNavController(nav_view, navController)
        nav_view.setNavigationItemSelectedListener(this)
    }


    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {

        when (menuItem.itemId) {
            R.id.nav_profile -> {
                if (isDestinationValid(R.id.nav_posts)) {
                    val navOptions = NavOptions.Builder().setPopUpTo(R.id.main_graph, true).build()
                    Navigation.findNavController(this, R.id.nav_host_fragment).navigate(
                        R.id.profileFragment, null, navOptions
                    )
                }

            }

            R.id.nav_posts -> {
                if (isDestinationValid(R.id.nav_posts)) {
                    Navigation.findNavController(
                        this,
                        R.id.nav_host_fragment
                    ).navigate(R.id.postsFragment)
                }

            }

        }
        menuItem.setChecked(true)
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(
            Navigation.findNavController(this, R.id.nav_host_fragment),
            drawer_layout
        )
    }

    private fun isDestinationValid(destination: Int): Boolean {
        return destination != Navigation.findNavController(
            this,
            R.id.nav_host_fragment
        ).currentDestination?.id
    }

}