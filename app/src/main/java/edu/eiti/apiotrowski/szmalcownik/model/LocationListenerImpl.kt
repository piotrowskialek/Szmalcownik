package edu.eiti.apiotrowski.szmalcownik.model

import android.location.Location
import android.location.LocationListener
import android.os.Bundle
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions


/**
 * Created by apiotrowski on 04.07.2017.
 */

class LocationListenerImpl(var googleMap: GoogleMap) : LocationListener {

    var title = "Ty"
    var currLocation: LatLng = LatLng(50.0, 20.0)
    var currMarker: Marker? = null


    override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
    }

    override fun onProviderEnabled(provider: String?) {
    }

    override fun onProviderDisabled(provider: String?) {
    }

    override fun onLocationChanged(location: Location?) {

        updateUserLocation(location)
    }

    private fun updateUserLocation(location: Location?) {

        currMarker?.remove()
        currLocation = LatLng((location?.latitude) ?: 0.0, (location?.longitude) ?: 0.0)
        currMarker = googleMap.addMarker(MarkerOptions().position(currLocation).title(title))//Ty
//        googleMap.moveCamera(CameraUpdateFactory.newLatLng(currLocation))

    }
}
