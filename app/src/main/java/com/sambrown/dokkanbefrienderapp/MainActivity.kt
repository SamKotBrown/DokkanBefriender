package com.sambrown.dokkanbefrienderapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.sambrown.dokkanbefrienderapp.ui.theme.DokkanBefrienderAppTheme
import com.sambrown.dokkanbefrienderapp.view.NavGraphs.root
import com.ramcosta.composedestinations.DestinationsNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DokkanBefrienderAppTheme {
                DestinationsNavHost(navGraph = root)
            }
        }
    }
}