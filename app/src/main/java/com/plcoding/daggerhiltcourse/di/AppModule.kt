package com.plcoding.daggerhiltcourse.di

import android.app.Application
import com.plcoding.daggerhiltcourse.data.remote.DummyApi
import com.plcoding.daggerhiltcourse.data.repository.DummyRepositoryImpl
import com.plcoding.daggerhiltcourse.domain.repository.DummyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
/*
Notes:
@InstallIn() - The component that will be used for this depends on the type of the dependencies you will
               provide in the specific module. You can have multiple modules with different lifecycles.
               EX: You can have modules with dependencies that will live as long as the app(Singleton),
               or as long as an Activity.
Types of Component:
               1) SingletonComponent - for singletons
               2) ActivityComponent - dependencies will live as long as the Activity they are
                                      injected into
               3) ViewModelComponent - dependencies will live as long as the ViewModel they are
                                      injected into
               4) ActivityRetainedComponent - dependencies will not be destroyed when the Activity
                                      is rotated and recreated
               5) ServiceComponent - for services
 */
object AppModule {

    @Provides
    @Singleton
    fun provideDummyApi(): DummyApi {
        return Retrofit.Builder()
            .baseUrl("https://test.com")
            .build()
            .create(DummyApi::class.java)
    }

    //Commented out: See RepositoryModule for a different implementation
//    @Provides
//    @Singleton
//    fun provideDummyRepository(dummyApi: DummyApi,
//                               application: Application,
//                               @Named("HelloWorld1") helloWorld1: String
//    ): DummyRepository {
//        return DummyRepositoryImpl(dummyApi, application)
//    }


    /*
    Notes: For dependencies of same type, use @Named annotation
     */
    @Provides
    @Singleton
    @Named("HelloWorld1")
    fun provideHelloWorld1() = "Hello World 1"

    @Provides
    @Singleton
    @Named("HelloWorld2")
    fun provideHelloWorld2() = "Hello World 2"
}