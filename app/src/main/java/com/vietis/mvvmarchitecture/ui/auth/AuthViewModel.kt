package com.vietis.mvvmarchitecture.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.vietis.mvvmarchitecture.data.repositories.UserRepository
import com.vietis.mvvmarchitecture.util.Coroutines

class AuthViewModel : ViewModel() {
    var email: String? = null
    var password: String? = null
    var authListener: AuthListener? = null

    fun onLoginBtnClick(view: View) {
        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            authListener?.onFailure("Invalid email or password")
            return
        }

        Coroutines.main {
            val response = UserRepository().userLogin(email!!, password!!)
            if (response.isSuccessful) {
                authListener?.onSuccess(response.body()?.user!!)
            } else {
                authListener?.onFailure("Error Code: ${response.code()}")
            }
        }

    }
}