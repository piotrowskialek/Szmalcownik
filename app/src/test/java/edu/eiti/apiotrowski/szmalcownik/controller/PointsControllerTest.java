package edu.eiti.apiotrowski.szmalcownik.controller;

import android.location.Location;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by apiotrowski on 08.07.2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class PointsControllerTest {

    private PointsController controller = new PointsController();

    @Mock
    private
    Location location = new Location("xD");



    @Test
    void addDangerousPoint() {

//        when(location.getLatitude()).thenReturn(21.0);
//        when(location.getLongitude()).thenReturn(37.0);
//
//        location.setAccuracy(1);
//
//        controller.addDangerousPoint(location);
//        System.out.println(controller.getDangerousCollection().size());
//        assertEquals(controller.getDangerousPoints().size(), 0);
//        //nie da sie markerow ani google mapsow mockowac (albo nie wiem jak) wiec kupa niesamowita

    }

    @Test
    void removeMarker() {

//        when(location.getLatitude()).thenReturn(21.0);
//        when(location.getLongitude()).thenReturn(37.0);
//        location.setAccuracy(1);
//
//        controller.addDangerousPoint(location);
//        controller.removeMarker(0);
//        assertEquals(controller.getDangerousPoints().size(), 0);
//        //nie da sie markerow ani google mapsow mockowac (albo nie wiem jak) wiec kupa niesamowita

    }

}
