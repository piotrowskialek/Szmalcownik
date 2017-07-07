package edu.eiti.apiotrowski.szmalcownik.controller

import android.location.Location
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.CircleOptions
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

/**
 * Created by apiotrowski on 07.07.2017.
 */

class PointsController {

    var title = "Kanar uciekać"
    var circleRadius = 10.0
    var currLocation: LatLng = LatLng(50.0, 20.0)
    var googleMap: GoogleMap? = null
    var dangerousCollection: MutableList<LatLng> = emptyList<LatLng>() as MutableList<LatLng>
    val ZOOM = 17f
    val RED: Int = 0x88ff0000.toInt()


    fun addDangerousPoint(location: Location) {
        showOnMap(location)
        dangerousCollection.add(LatLng(location.latitude, location.longitude))
    }

    fun getDangerousPoints(): List<LatLng> {
        return dangerousCollection
    }

    fun showOnMap(location: Location) {

        currLocation = LatLng(location.latitude, location.longitude)

        googleMap?.addCircle(CircleOptions().center(currLocation)
                .clickable(true)
                .radius(circleRadius)
                .fillColor(RED))

        googleMap?.addMarker(MarkerOptions().position(currLocation).title(title))
        googleMap?.moveCamera(CameraUpdateFactory.newLatLng(currLocation))
        googleMap?.animateCamera(CameraUpdateFactory.zoomTo(ZOOM))
    }

}