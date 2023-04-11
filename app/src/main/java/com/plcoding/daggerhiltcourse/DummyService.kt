package com.plcoding.daggerhiltcourse

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.plcoding.daggerhiltcourse.domain.repository.DummyRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

// Need this annotation because Service is an Android Component
@AndroidEntryPoint
class DummyService: Service() {

    // You can also use field injection in this case because you can't use constructor injection
    // because a service has no constructor
    @Inject
    lateinit var repository: DummyRepository

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }
}