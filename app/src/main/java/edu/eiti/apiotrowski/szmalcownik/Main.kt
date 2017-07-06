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
import android.Manifest.permission.WRITE_CALENDAR
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.util.Log


class Main : FragmentActivity(), OnMapReadyCallback {


    private val INITIAL_PERMS = arrayOf<String>(android.Manifest.permission.ACCESS_FINE_LOCATION)
    private val CAMERA_PERMS = arrayOf<String>(android.Manifest.permission.CAMERA)
    private val CONTACTS_PERMS = arrayOf<String>(android.Manifest.permission.READ_CONTACTS)
    private val LOCATION_PERMS = arrayOf<String>(android.Manifest.permission.ACCESS_FINE_LOCATION)
    private val INITIAL_REQUEST = 1337
//    private val CAMERA_REQUEST = INITIAL_REQUEST + 1
//    private val CONTACTS_REQUEST = INITIAL_REQUEST + 2
//    private val LOCATION_REQUEST = INITIAL_REQUEST + 3


    private var mMap: GoogleMap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        val permissionCheck = ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION)

        ActivityCompat.requestPermissions(this,
                arrayOf<String>(android.Manifest.permission.ACCESS_FINE_LOCATION),INITIAL_REQUEST)


//        requestPermissions(INITIAL_PERMS)
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
