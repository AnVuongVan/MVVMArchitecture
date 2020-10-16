package com.vietis.mvvmarchitecture.ui.auth

import com.vietis.mvvmarchitecture.data.db.entities.User

interface AuthListener {
    fun onStarted()
    fun onSuccess(user: User)
    fun onFailure(message: String)
}