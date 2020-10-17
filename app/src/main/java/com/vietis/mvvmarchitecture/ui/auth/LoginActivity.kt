package com.vietis.mvvmarchitecture.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.vietis.mvvmarchitecture.R
import com.vietis.mvvmarchitecture.data.db.entities.User
import com.vietis.mvvmarchitecture.databinding.ActivityLoginBinding
import com.vietis.mvvmarchitecture.util.hide
import com.vietis.mvvmarchitecture.util.show
import com.vietis.mvvmarchitecture.util.snackbar
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), AuthListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        val viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)
        binding.viewmodel = viewModel

        viewModel.authListener = this
    }

    override fun onStarted() {
        progress_bar.show()
    }

    override fun onSuccess(user: User) {
        progress_bar.hide()
        root_layout.snackbar("${user.name} is logged in")
    }

    override fun onFailure(message: String) {
        progress_bar.hide()
        root_layout.snackbar(message)
    }
}