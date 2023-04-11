package com.plcoding.daggerhiltcourse.data.repository

import android.app.Application
import com.plcoding.daggerhiltcourse.R
import com.plcoding.daggerhiltcourse.data.remote.DummyApi
import com.plcoding.daggerhiltcourse.domain.repository.DummyRepository
import javax.inject.Inject

/*
Notes: Constructor Injection is another way of injecting dependencies as long as
Dagger knows how to create the dependencies inside the constructor. In this case, you no longer
need a @Provides function for this.
 */
class DummyRepositoryImpl @Inject constructor(
    private val dummyApi: DummyApi,
    private val appContext: Application
): DummyRepository {

    init {
        val appName = appContext.getString(R.string.app_name)
        println("Hello from the repository. The app name is $appName")
    }

    override suspend fun doNetworkCall() {

    }


}