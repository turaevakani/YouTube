package com.example.youtube.di

import com.example.youtube.data.repositories.YouTubeRepository
import org.koin.dsl.module

val  repository  = module {
    single { YouTubeRepository(get()) }
}