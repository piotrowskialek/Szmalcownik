package edu.eiti.apiotrowski.szmalcownik.controller;

import android.content.Context;
import android.location.Location;
import android.test.mock.MockContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.Assert.assertEquals;

/**
 * Created by apiotrowski on 08.07.2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class PointsControllerTest {
    PointsController controller = new PointsController();
    Context context = new MockContext();

    @Mock
    Location location = new Location("test");

    @Test
    void addDangerousPoint() {

        controller.addDangerousPoint(location);
        assertEquals(controller.getDangerousPoints().size(), 1);
    }

    @Test
    void removeMarker() {

        controller.addDangerousPoint(location);
        controller.removeMarker(0);
        assertEquals(controller.getDangerousPoints().size(), 0);
    }

}
