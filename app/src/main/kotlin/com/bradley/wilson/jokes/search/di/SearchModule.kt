package com.bradley.wilson.jokes.search.di

import com.bradley.wilson.jokes.search.SearchViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val searchModule: Module = module {
    viewModel {
        SearchViewModel(get(), get())
    }
}