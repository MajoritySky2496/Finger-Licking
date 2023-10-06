package com.example.finger_licking.di

import com.example.finger_licking.viewModel.ProductViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::ProductViewModel)
}