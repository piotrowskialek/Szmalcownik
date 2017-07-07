package edu.eiti.apiotrowski.szmalcownik.controller

import android.location.Location
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Created by apiotrowski on 07.07.2017.
 */
class PointsControllerTest {
    @Test
    fun addDangerousPoint() {

        val controller = PointsController();
        controller.addDangerousPoint(Location("test"))
        assertEquals(controller.getDangerousPoints().size, 1)

    }

}