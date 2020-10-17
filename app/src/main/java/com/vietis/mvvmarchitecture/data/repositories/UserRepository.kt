package com.vietis.mvvmarchitecture.data.repositories

import com.vietis.mvvmarchitecture.data.db.AppDatabase
import com.vietis.mvvmarchitecture.data.db.entities.User
import com.vietis.mvvmarchitecture.data.network.MyApi
import com.vietis.mvvmarchitecture.data.network.SafeApiRequest
import com.vietis.mvvmarchitecture.data.network.responses.AuthResponse
import retrofit2.Response

class UserRepository(
    private val api: MyApi,
    private val db: AppDatabase
) : SafeApiRequest() {

    suspend fun userLogin(email: String, password: String) : AuthResponse {
        return apiRequest { api.userLogin(email, password)
        }
    }

    suspend fun userRegister(
        name: String,
        email: String,
        password: String
    ) : AuthResponse {
        return apiRequest { api.userRegister(name, email, password) }
    }

    suspend fun saveUser(user: User) = db.getUserDao().insert(user)

    fun getUser() = db.getUserDao().getUser()

}