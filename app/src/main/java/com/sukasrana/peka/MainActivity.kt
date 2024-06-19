package com.sukasrana.peka


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import com.sukasrana.peka.network.maps.LocationHelper
import com.sukasrana.peka.presentation.Peka
import com.sukasrana.peka.ui.theme.PekaTheme

class MainActivity : ComponentActivity() {

    private lateinit var locationHelper: LocationHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        locationHelper = LocationHelper(this)

        setContent {
            PekaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Peka(locationHelper = locationHelper)
                }
            }
        }
    }
}
