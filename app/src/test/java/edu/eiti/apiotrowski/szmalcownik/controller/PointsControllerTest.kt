package edu.eiti.apiotrowski.szmalcownik.controller

import android.content.Context
import android.location.Location
import android.test.mock.MockContext
import org.junit.Assert.assertEquals
import org.junit.Test


/**
 * Created by apiotrowski on 07.07.2017.
 */

class PointsControllerTest {

    val controller = PointsController()
    val context: Context = MockContext()

    val location = mock<Location> {
        on { latitude } doReturn 21.0
        on { longitude } doReturn 37.0
    }

    @Test
    @Throws(Exception::class)
    fun addDangerousPoint() {

        controller.addDangerousPoint(location)
        assertEquals(controller.getDangerousPoints().size, 1)

    }
//
//    @Test
//    @Throws(Exception::class)
//    fun removeMarker() {
//
//        controller.addDangerousPointlocation(location)
//        controller.removeMarker(0)
//        assertEquals(controller.getDangerousPoints(), 0)
//    }

}