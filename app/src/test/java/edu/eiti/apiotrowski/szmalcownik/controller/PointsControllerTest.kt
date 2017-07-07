package edu.eiti.apiotrowski.szmalcownik.controller

import android.location.Location
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Created by apiotrowski on 07.07.2017.
 */
class PointsControllerTest {

    val controller = PointsController()

    @Test
    fun addDangerousPoint() {

        controller.addDangerousPoint(Location("test"))
        assertEquals(controller.getDangerousPoints().size, 1)
    }

    @Test
    fun removeMarker(index: Int) {

        controller.addDangerousPoint(Location("test"))
        controller.removeMarker(0)
        assertEquals(controller.getDangerousPoints(), 0)
    }

}