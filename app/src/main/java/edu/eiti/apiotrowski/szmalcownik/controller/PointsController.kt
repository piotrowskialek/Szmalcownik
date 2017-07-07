package edu.eiti.apiotrowski.szmalcownik.controller

import android.location.Location
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.CircleOptions
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions

/**
 * Created by apiotrowski on 07.07.2017.
 */

class PointsController {

    var title = "Kanar uciekać"
    var circleRadius = 10.0
    var currLocation: LatLng = LatLng(50.0, 20.0)
    var googleMap: GoogleMap? = null
    var dangerousCollection: MutableList<Marker> = emptyList<Marker>() as MutableList<Marker>
    var marker: Marker? = null

    val RED: Int = 0x88ff0000.toInt()


    fun addDangerousPoint(location: Location) {

        currLocation = LatLng(location.latitude, location.longitude)

        googleMap?.addCircle(CircleOptions().center(currLocation)
                .clickable(true)
                .radius(circleRadius)
                .fillColor(RED))

        marker = googleMap?.addMarker(MarkerOptions().position(currLocation).title(title))
        dangerousCollection.add(marker!!)

    }

    fun getDangerousPoints(): List<Marker> {
        return dangerousCollection
    }

    fun removeMarker(index: Int) {
        dangerousCollection[index].remove()
    }


}