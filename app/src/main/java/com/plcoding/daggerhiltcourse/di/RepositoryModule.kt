package com.plcoding.daggerhiltcourse.di

import com.plcoding.daggerhiltcourse.data.repository.DummyRepositoryImpl
import com.plcoding.daggerhiltcourse.domain.repository.DummyRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/*
Notes: This is another way of providing interfaces that generates lesser code than doing the
@Provides.

When to use (tip only and not a hard rule):
    1) When you are providing an implementation that you own(not Android/third party lib owned),
       you can use this instead of @Provides.
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    // Notes: This makes sure that when a DummyRepository is called, it will always return
    // this specific implementation
    @Binds
    @Singleton
    abstract fun bindMyRepository(
        dummyRepositoryImpl: DummyRepositoryImpl
    ): DummyRepository
}