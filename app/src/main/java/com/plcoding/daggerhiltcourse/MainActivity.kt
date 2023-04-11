package com.plcoding.daggerhiltcourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import com.plcoding.daggerhiltcourse.ui.theme.DaggerHiltCourseTheme
import dagger.hilt.android.AndroidEntryPoint

// Need to use this annotation when injecting into any Android component class (Activity, Fragment)
// Another way of injecting viewmodel to activity:
// @AndroidEntryPoint
//  class ExampleActivity : AppCompatActivity() {
//      private val exampleViewModel: ExampleViewModel by viewModels()
//  ...
//
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DaggerHiltCourseTheme {
                val viewModel = hiltViewModel<MainViewModel>()
            }
        }
    }
}