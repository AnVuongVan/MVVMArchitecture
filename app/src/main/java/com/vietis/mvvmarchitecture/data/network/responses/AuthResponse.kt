package com.vietis.mvvmarchitecture.data.network.responses

import com.vietis.mvvmarchitecture.data.db.entities.User

data class AuthResponse (
    val isSuccessful: Boolean?,
    val message: String?,
    val user: User?
)