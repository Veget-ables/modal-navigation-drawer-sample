package com.example.modal_navigation_drawer_sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import com.example.modal_navigation_drawer_sample.ui.LeftAndRightModalDrawerScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                LeftAndRightModalDrawerScreen()
            }
        }
    }
}