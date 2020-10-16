package com.vietis.mvvmarchitecture.data.repositories

import com.vietis.mvvmarchitecture.data.network.MyApi
import com.vietis.mvvmarchitecture.data.network.responses.AuthResponse
import retrofit2.Response

class UserRepository {

    suspend fun userLogin(email: String, password: String) : Response<AuthResponse> {
        return MyApi().userLogin(email, password)
    }

}