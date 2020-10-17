package com.vietis.mvvmarchitecture.data.repositories

import com.vietis.mvvmarchitecture.data.network.MyApi
import com.vietis.mvvmarchitecture.data.network.SafeApiRequest
import com.vietis.mvvmarchitecture.data.network.responses.AuthResponse
import retrofit2.Response

class UserRepository : SafeApiRequest() {

    suspend fun userLogin(email: String, password: String) : AuthResponse {
        return apiRequest {
            MyApi().userLogin(email, password)
        }
    }

}