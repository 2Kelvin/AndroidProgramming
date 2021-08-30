package com.r19.mygooglemapsapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.r19.mygooglemapsapplication.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Added markers of Kenyan towns; move the camera
        val tatuCity = LatLng(-1.1283568, 36.8636347)
        mMap.addMarker(MarkerOptions().position(tatuCity).title("Marker in Tatu City"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(tatuCity))

        val naivasha = LatLng(-0.7134721, 36.4147574)
        mMap.addMarker(MarkerOptions().position(naivasha).title("Marker in Naivasha"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(naivasha))

        val mombasa = LatLng(-4.0350145, 39.5962226)
        mMap.addMarker(MarkerOptions().position(mombasa).title("Marker in Mombasa"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(mombasa))

        val thika = LatLng(-1.0418398, 37.0234127)
        mMap.addMarker(MarkerOptions().position(thika).title("Marker in Thika"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(thika))
    }
}