package com.vietis.mvvmarchitecture.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.vietis.mvvmarchitecture.data.repositories.UserRepository
import com.vietis.mvvmarchitecture.util.ApiException
import com.vietis.mvvmarchitecture.util.Coroutines

class AuthViewModel(
    private val repository: UserRepository
) : ViewModel() {
    var email: String? = null
    var password: String? = null
    var authListener: AuthListener? = null

    fun getLoggedInUser() = repository.getUser()

    fun onLoginBtnClick(view: View) {
        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            authListener?.onFailure("Invalid email or password")
            return
        }

        Coroutines.main {
            try {
                val authResponse = repository.userLogin(email!!, password!!)
                authResponse.user?.let {
                    authListener?.onSuccess(it)
                    repository.saveUser(it)
                    return@main
                }
                authListener?.onFailure(authResponse.message!!)
            } catch (e: ApiException) {
                authListener?.onFailure(e.message!!)
            }
        }

    }
}