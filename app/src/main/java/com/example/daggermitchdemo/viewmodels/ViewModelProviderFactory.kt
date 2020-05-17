package com.example.daggermitchdemo.viewmodels

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModel
import javax.inject.Inject
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import javax.inject.Provider


/**
 *Created by Ankit Bajaj on 17-05-2020.
 */
class ViewModelProviderFactory @Inject constructor(val creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>) :
    ViewModelProvider.Factory {

    private val TAG = "ViewModelProviderFactor"

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        var creator: Provider<out ViewModel>? = creators[modelClass]
        if (creator == null) { // if the viewmodel has not been created

            // loop through the allowable keys (aka allowed classes with the @ViewModelKey)
            for ((key, value) in creators) {

                // if it's allowed, set the Provider<ViewModel>
                if (modelClass.isAssignableFrom(key)) {
                    creator = value
                    break
                }
            }
        }

        // if this is not one of the allowed keys, throw exception
        requireNotNull(creator) { "unknown model class $modelClass" }

        // return the Provider
        try {
            return creator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }

    }

}