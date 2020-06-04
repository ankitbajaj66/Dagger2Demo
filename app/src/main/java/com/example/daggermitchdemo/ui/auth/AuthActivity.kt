package com.example.daggermitchdemo.ui.auth

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.RequestManager
import com.example.daggermitchdemo.R
import com.example.daggermitchdemo.models.User
import com.example.daggermitchdemo.viewmodels.ViewModelProviderFactory
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_auth.*
import javax.inject.Inject

class AuthActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    lateinit var authViewModel: AuthViewModel


    @set:Inject
    var drawable: Drawable? = null

    @Inject
    lateinit var requestManager: RequestManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        authViewModel = ViewModelProvider(this, providerFactory).get(AuthViewModel::class.java)

        setLogo()

        subscribeUser()

        login_button.setOnClickListener {
            if (!TextUtils.isEmpty(user_id_input.text.toString())) {
                authViewModel.authenticateUsingId(user_id_input.text.toString().toInt())
            }
        }

    }

    fun setLogo() {
        requestManager.load(drawable).into(login_logo)
    }

    private fun subscribeUser() {
        authViewModel.getAuthUser().observe(this, Observer<User> { user ->
            user?.let {
                Log.d("AuthActivity", "Users Email Address ${user.email}")
            }
        })
    }
}
