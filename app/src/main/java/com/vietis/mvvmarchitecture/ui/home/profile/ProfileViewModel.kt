package com.vietis.mvvmarchitecture.ui.home.profile

import androidx.lifecycle.ViewModel
import com.vietis.mvvmarchitecture.data.repositories.UserRepository

class ProfileViewModel(
    repository: UserRepository
) : ViewModel() {
    val user = repository.getUser()
}