package com.bradley.wilson.jokes.home.di

import com.bradley.wilson.jokes.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val homeModule: Module = module {
    viewModel {
        HomeViewModel(get(), get())
    }
}