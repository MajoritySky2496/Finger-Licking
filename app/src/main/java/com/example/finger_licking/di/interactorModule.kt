package com.example.finger_licking.di

import com.example.domain.Interactor
import com.example.domain.impl.InteractorImpl
import org.koin.dsl.module

val interactorModule = module {
    single<Interactor>{InteractorImpl(get())}

}