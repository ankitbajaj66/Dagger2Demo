package com.example.daggermitchdemo.ui.main.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.daggermitchdemo.R
import com.example.daggermitchdemo.models.User
import com.example.daggermitchdemo.ui.auth.AuthResource
import com.example.daggermitchdemo.viewmodels.ViewModelProviderFactory
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_profile.*
import javax.inject.Inject


/**
 *Created by Ankit Bajaj on 05-06-2020.
 */
class ProfileFragment : DaggerFragment() {

    lateinit var profileViewModel: ProfileViewModel

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Toast.makeText(activity, "ProfileFragment", Toast.LENGTH_LONG).show()
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        profileViewModel =
            ViewModelProvider(this, viewModelProviderFactory).get(ProfileViewModel::class.java)

        subscribeObserver()
    }

    private fun subscribeObserver() {
        profileViewModel.getAuthenticatedUser().removeObservers(viewLifecycleOwner)
        profileViewModel.getAuthenticatedUser()
            .observe(viewLifecycleOwner, Observer<AuthResource<User>> {

                    authResponse ->
                authResponse?.let {

                    when (authResponse) {
                        is AuthResource.AUTHENTICATED -> setUserDetails(authResponse.data)
                        is AuthResource.Error -> setError(authResponse.message)
                    }
                }
            })
    }

    private fun setUserDetails(user: User?) {
        user?.let {
            email.text = it.email
            username.text = it.username
            website.text = it.website

        }
    }

    private fun setError(error: String?) {
        error?.let {
            email.text = it
        }
    }
}