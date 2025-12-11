package com.diana818.newsapp.di

import com.diana818.newsapp.data.repository.NewsRepositoryImpl
import com.diana818.newsapp.domain.repository.NewsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    // This tells Hilt: whenever someone needs a NewsRepository (Interface),
    // provide a NewsRepositoryImpl (Implementation).
    @Binds
    @Singleton
    abstract fun bindNewsRepository(
        newsRepositoryImpl: NewsRepositoryImpl
    ): NewsRepository
}