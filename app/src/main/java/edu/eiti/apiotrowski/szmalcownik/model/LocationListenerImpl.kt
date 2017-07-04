package edu.eiti.apiotrowski.szmalcownik.model

import android.location.Location
import android.location.LocationListener
import android.os.Bundle


/**
 * Created by apiotrowski on 04.07.2017.
 */

class LocationListenerImpl : LocationListener {

    var lat: Double = 0.0
    var long: Double = 0.0

    override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
    }

    override fun onProviderEnabled(provider: String?) {
    }

    override fun onProviderDisabled(provider: String?) {
    }

    override fun onLocationChanged(location: Location?) {
        lat = location!!.latitude
        long = location.longitude
    }
}
