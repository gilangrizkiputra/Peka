package com.sukasrana.peka.network.maps

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Looper
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.google.android.gms.maps.model.LatLng

class LocationHelper(private val activity: ComponentActivity) {

    private val permissions = arrayOf(
        Manifest.permission.ACCESS_COARSE_LOCATION,
        Manifest.permission.ACCESS_FINE_LOCATION
    )

    private var fusedLocationClient: FusedLocationProviderClient
    private lateinit var locationCallback: LocationCallback

    var currentLocation: LatLng = LatLng(0.0, 0.0)
        private set

    private var locationRequired: Boolean = false

    init {
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(activity)
        initLocationCallback()
    }

    private val permissionLauncher: ActivityResultLauncher<Array<String>> =
        activity.registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
            val allGranted = permissions.values.all { it }
            if (allGranted) {
                locationRequired = true
                startLocationUpdate()
                Toast.makeText(activity, "Permission Granted", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(activity, "Permission Denied", Toast.LENGTH_SHORT).show()
            }
        }

    @SuppressLint("MissingPermission")
    private fun startLocationUpdate() {
        val locationRequest = LocationRequest.Builder(
            Priority.PRIORITY_HIGH_ACCURACY, 100
        )
            .setWaitForAccurateLocation(false)
            .setMinUpdateIntervalMillis(3000)
            .setMaxUpdateAgeMillis(100)
            .build()

        fusedLocationClient.requestLocationUpdates(
            locationRequest,
            locationCallback,
            Looper.getMainLooper()
        )
    }

    fun checkPermissionsAndStartLocationUpdate() {
        if (permissions.all {
                ContextCompat.checkSelfPermission(activity, it) == PackageManager.PERMISSION_GRANTED
            }) {
            startLocationUpdate()
        } else {
            permissionLauncher.launch(permissions)
        }
    }

    private fun initLocationCallback() {
        locationCallback = object : LocationCallback() {
            override fun onLocationResult(p0: LocationResult) {
                super.onLocationResult(p0)
                for (location in p0.locations) {
                    currentLocation = LatLng(location.latitude, location.longitude)
                }
            }
        }
    }
}
