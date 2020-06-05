package com.example.daggermitchdemo

import android.content.Intent
import android.util.Log
import androidx.lifecycle.Observer
import com.example.daggermitchdemo.models.User
import com.example.daggermitchdemo.ui.auth.AuthActivity
import com.example.daggermitchdemo.ui.auth.AuthResource
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

/**
 *Created by Ankit Bajaj on 05-06-2020.
 */
abstract class BaseActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var sessionManager: SessionManager

    fun subscribeObserver() {
        sessionManager.getAuthUser().observe(this, Observer<AuthResource<User>> { authResponse ->
            authResponse?.let {

                when (authResponse) {
                    is AuthResource.AUTHENTICATED -> {
                        Log.d(
                            "AuthViewModel",
                            "User Data --- ${authResponse.data?.email}"
                        )

                    }

                    is AuthResource.Loading -> {
                        Log.d(
                            "AuthViewModel",
                            "Loading..............}"
                        )
                    }
                    is AuthResource.Error -> {
                        Log.d(
                            "AuthViewModel",
                            "Error..............${authResponse.message}"
                        )
                    }

                    is AuthResource.NOTAUTHENTICATED -> {
                        Log.d(
                            "AuthViewModel",
                            "Not Authticated............"
                        )
                        navigateLoginScreen()
                    }
                }
            }
        })
    }

    fun navigateLoginScreen() {
        val intent = Intent(this, AuthActivity::class.java)
        startActivity(intent)
        finish()

    }
}