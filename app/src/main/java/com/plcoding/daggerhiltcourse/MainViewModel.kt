package com.plcoding.daggerhiltcourse

import androidx.lifecycle.ViewModel
import com.plcoding.daggerhiltcourse.domain.repository.DummyRepository
import dagger.Lazy
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

//@HiltViewModel only accepts constructor injection
//@HiltViewModel annotated class should contain exactly one @Inject annotated constructor.
@HiltViewModel
class MainViewModel @Inject constructor(
    // Lazy Inject: Delays the creation of the dependency.
    // Only created when used.
    // Tip: Use this when there is a possibility that a variable won't be called/read. can
    // improve performance because it won't be created instantly
    private val repository: Lazy<DummyRepository>
): ViewModel() {


    init {
        repository.get()
    }
}