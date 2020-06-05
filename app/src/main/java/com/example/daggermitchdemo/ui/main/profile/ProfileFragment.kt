package com.example.daggermitchdemo.ui.main.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.daggermitchdemo.R
import dagger.android.support.DaggerFragment


/**
 *Created by Ankit Bajaj on 05-06-2020.
 */
class ProfileFragment : DaggerFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Toast.makeText(activity, "ProfileFragment", Toast.LENGTH_LONG).show()
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }
}