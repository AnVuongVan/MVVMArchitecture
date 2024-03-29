package com.vietis.mvvmarchitecture.ui.auth

import androidx.lifecycle.ViewModel
import com.vietis.mvvmarchitecture.data.db.entities.User
import com.vietis.mvvmarchitecture.data.repositories.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AuthViewModel(
    private val repository: UserRepository
) : ViewModel() {

    fun getLoggedInUser() = repository.getUser()

    suspend fun userLogin(
        email: String,
        password: String
    ) = withContext(Dispatchers.IO) { repository.userLogin(email, password) }

    suspend fun userRegister(
        name: String,
        email: String,
        password: String
    ) = withContext(Dispatchers.IO) { repository.userRegister(name, email, password) }

    suspend fun saveLoggedInUser(user: User) = repository.saveUser(user)

}