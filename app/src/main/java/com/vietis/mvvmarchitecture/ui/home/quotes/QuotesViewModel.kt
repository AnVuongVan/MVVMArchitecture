package com.vietis.mvvmarchitecture.ui.home.quotes

import androidx.lifecycle.ViewModel
import com.vietis.mvvmarchitecture.data.repositories.QuotesRepository
import com.vietis.mvvmarchitecture.util.lazyDeferred

class QuotesViewModel(
    repository: QuotesRepository
) : ViewModel() {
    val quotes by lazyDeferred {
        repository.getQuotes()
    }
}