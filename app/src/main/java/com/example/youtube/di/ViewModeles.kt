package com.example.youtube.di

import com.example.youtube.ui.main.MainViewModel
import com.example.youtube.ui.second.SecondViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viwmodules = module {
    viewModel { MainViewModel(get()) }
    viewModel { SecondViewModel(get()) }
}