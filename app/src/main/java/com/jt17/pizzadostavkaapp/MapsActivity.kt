package com.jt17.pizzadostavkaapp

import android.location.Address
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.button.MaterialButton
import com.jt17.pizzadostavkaapp.databinding.ActivityMapsBinding
import java.util.*

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

    override fun onMapReady(googleMap: GoogleMap) {

        val tawkent = LatLng(41.315429, 69.282266)
        googleMap.addMarker(MarkerOptions().position(tawkent).title("Markaziy Pochta"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(tawkent))
        zomCamera(googleMap, tawkent)
        findViewById<MaterialButton>(R.id.address_btn).setOnClickListener {
            val tawkent = LatLng(
                googleMap.cameraPosition.target.latitude,
                googleMap.cameraPosition.target.longitude
            )
            val geocoder = Geocoder(this, Locale.getDefault())
            findViewById<TextView>(R.id.address_text).text =
                getAddress(tawkent, geocoder)

        }
    }
}

fun getAddress(latLng: LatLng, geocoder: Geocoder): String {
    val addresses: List<Address>?
    val address: Address?
    var fulladdress = ""
    addresses = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1)

    if (addresses!!.isNotEmpty()) {
        address = addresses.get(0)
        fulladdress =
            address.getAddressLine(0) // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex
        var city = address.getLocality();
        var state = address.getAdminArea();
        var country = address.getCountryName();
        var postalCode = address.getPostalCode();
        var knownName = address.getFeatureName(); // Only if available else return NULL
    } else {
        fulladdress = "Location not found"
    }

    return fulladdress
}

//override fun onMapReady(googleMap: GoogleMap) {
//    mMap = googleMap
//
//    val uzPochta = LatLng(41.317183, 69.284036)
////        getAddress(uzPochta)
//    googleMap.addMarker(
//        MarkerOptions()
//            .title("Bizni pochta")
//            .position(uzPochta)
//            .icon(locationIcon)
//    )
//
//}
fun zomCamera(mMap: GoogleMap, location: LatLng) {
// Move the camera instantly to Tawkent with a zoom of 15.
    // Kamerani 15 ga yaqinlashtirish bilan darhol Tawkent olib boring.
    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 15f))

// Zoom in, animating the camera.
    // Kattalashtirish, kamerani jonlantirish.
    mMap.animateCamera(CameraUpdateFactory.zoomIn())

// Zoom out to zoom level 10, animating with a duration of 2 seconds.
    // 10-darajani kattalashtirish uchun kichraytiring, animatsiya davomiyligi 2 soniya.
    mMap.animateCamera(CameraUpdateFactory.zoomTo(10f), 2000, null)

// Construct a CameraPosition focusing on Mountain View and animate the camera to that position.
    // Togʻli koʻrinishga qaratilgan CameraPosition-ni yarating va kamerani shu holatga keltiring.
    val cameraPosition = CameraPosition.Builder()
        .target(location) // Sets the center of the map to Mountain View
        .zoom(17f)            // Sets the zoom
        .bearing(90f)         // Sets the orientation of the camera to east
        .tilt(30f)            // Sets the tilt of the camera to 30 degrees
        .build()              // Creates a CameraPosition from the builder
    mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))
}