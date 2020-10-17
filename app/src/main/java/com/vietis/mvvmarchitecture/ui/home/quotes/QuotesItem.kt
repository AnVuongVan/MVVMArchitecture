package com.vietis.mvvmarchitecture.ui.home.quotes

import com.vietis.mvvmarchitecture.R
import com.vietis.mvvmarchitecture.data.db.entities.Quote
import com.vietis.mvvmarchitecture.databinding.ItemQuoteBinding
import com.xwray.groupie.databinding.BindableItem

class QuotesItem(
    private val quote: Quote
) : BindableItem<ItemQuoteBinding>() {

    override fun getLayout() = R.layout.item_quote

    override fun bind(viewBinding: ItemQuoteBinding, position: Int) {
        viewBinding.setQuote(quote)
    }

}