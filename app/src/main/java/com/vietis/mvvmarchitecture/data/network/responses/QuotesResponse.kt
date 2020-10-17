package com.vietis.mvvmarchitecture.data.network.responses

import com.vietis.mvvmarchitecture.data.db.entities.Quote

data class QuotesResponse(
    val isSuccessful: Boolean,
    val quotes: List<Quote>
)