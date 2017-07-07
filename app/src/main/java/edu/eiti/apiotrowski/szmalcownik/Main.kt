package edu.eiti.apiotrowski.szmalcownik

import android.content.Context
import android.location.LocationManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.FragmentActivity
import android.support.v4.content.ContextCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import edu.eiti.apiotrowski.szmalcownik.model.LocationListenerImpl


class Main : FragmentActivity(), OnMapReadyCallback {

    private val INITIAL_REQUEST = 1337
    val ZOOM = 17f

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment

        mapFragment.getMapAsync(this)

        val permissionCheck = ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION)

        if (permissionCheck.equals(-1)) {
            ActivityCompat.requestPermissions(this,
                    arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), INITIAL_REQUEST)
        }
    }


    override fun onMapReady(googleMap: GoogleMap) {

        val mlocManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        val mlocListener = LocationListenerImpl(googleMap)
        mlocManager.requestLocationUpdates("gps", 0, 0f, mlocListener)
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(LatLng(52.2318774, 21.00417100)))
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(ZOOM))

    }
}
