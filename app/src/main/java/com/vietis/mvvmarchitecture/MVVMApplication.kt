package com.vietis.mvvmarchitecture

import android.app.Application
import com.vietis.mvvmarchitecture.data.db.AppDatabase
import com.vietis.mvvmarchitecture.data.network.MyApi
import com.vietis.mvvmarchitecture.data.network.NetworkConnectionInterceptor
import com.vietis.mvvmarchitecture.data.preferences.PreferenceProvider
import com.vietis.mvvmarchitecture.data.repositories.QuotesRepository
import com.vietis.mvvmarchitecture.data.repositories.UserRepository
import com.vietis.mvvmarchitecture.ui.auth.AuthViewModelFactory
import com.vietis.mvvmarchitecture.ui.home.profile.ProfileViewModelFactory
import com.vietis.mvvmarchitecture.ui.home.quotes.QuotesViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class MVVMApplication : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@MVVMApplication))

        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from singleton { MyApi(instance()) }
        bind() from singleton { AppDatabase(instance()) }
        bind() from singleton { PreferenceProvider(instance()) }
        bind() from singleton { UserRepository(instance(), instance()) }
        bind() from singleton { QuotesRepository(instance(), instance(), instance()) }
        bind() from provider { AuthViewModelFactory(instance()) }
        bind() from provider { ProfileViewModelFactory(instance()) }
        bind() from provider { QuotesViewModelFactory(instance()) }

    }

}