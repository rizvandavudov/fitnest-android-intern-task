package com.rizvandavudov.fitnest.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.rizvandavudov.fitnest.core.designsystem.FitNestTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(
        savedInstanceState: Bundle?,
    ) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            FitNestTheme {
                FitNestApp(
                    modifier = Modifier.fillMaxSize(),
                )
            }
        }
    }
}