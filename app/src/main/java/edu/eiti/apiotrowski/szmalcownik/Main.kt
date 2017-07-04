package edu.eiti.apiotrowski.szmalcownik

import android.content.Context
import android.location.LocationManager
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CircleOptions
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import edu.eiti.apiotrowski.szmalcownik.model.LocationListenerImpl


class Main : FragmentActivity(), OnMapReadyCallback {

    private var mMap: GoogleMap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val mlocManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        val mlocListener = LocationListenerImpl()


        mlocManager.requestLocationUpdates("gps", 0, 0f, mlocListener)


        val pkin = LatLng(52.219978, 21.011543)


        mMap!!.addCircle(CircleOptions().center(pkin)
                .clickable(true)
                .radius(10.0)
                .fillColor(0x88ff0000.toInt()))

        mMap!!.addMarker(MarkerOptions().position(pkin).title("KANAR!!! SPIERDALAĆ!!!"))
        mMap!!.moveCamera(CameraUpdateFactory.newLatLng(pkin))
        mMap!!.animateCamera(CameraUpdateFactory.zoomTo(17f));
    }
}
