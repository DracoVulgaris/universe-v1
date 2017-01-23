package com.universe.utilities;

import com.universe.environment.Location;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static com.universe.utilities.LocationHelper.getWeightedQuantityLocationMatrix;
import static com.universe.utilities.LocationHelper.maximumDistanceFromCentrePoint;
import static org.junit.Assert.*;

/**
 * Test for {@link LocationHelper}
 *
 * @since 22/01/2017.
 */
public class LocationHelperTest {

    private Location centrePoint;

    @Before
    public void setUp() throws Exception {
        centrePoint = new Location(5,5,5);
    }

    @Test
    public void getWeightedLocationMatrixZeroSpread() throws Exception {
        Map<Location, Integer> response = getWeightedQuantityLocationMatrix(centrePoint, 100, 0);
        assertNotNull(response);
        Integer actual = response.get(centrePoint);
        assertEquals(new Integer(100), actual);
        assertEquals(1, response.size());
    }

    @Test
    public void getWeightedLocationMatrixZeroMaxQuantity() throws Exception {
        Map<Location, Integer> response = getWeightedQuantityLocationMatrix(centrePoint, 0, 5);
        assertNotNull(response);
        Integer actual = response.get(centrePoint);
        assertEquals(new Integer(0), actual);
        assertEquals(1, response.size());
    }

    @Test
    public void getWeightedLocationMatrixSpreadThree() throws Exception {
        Map<Location, Integer> response = getWeightedQuantityLocationMatrix(centrePoint, 100, 3);
        assertNotNull(response);
        assertEquals(cubeSizeCalculator(3), new Integer(response.size()));
    }

    @Test
    public void getWeightedLocationMatrixSpreadFour() throws Exception {
        Map<Location, Integer> response = getWeightedQuantityLocationMatrix(centrePoint, 100, 4);
        assertNotNull(response);
        assertEquals(cubeSizeCalculator(4), new Integer(response.size()));
    }

    @Test
    public void maximumDistanceFromCentrePointTestThreeFourFive() throws Exception {
        Location location = new Location(3,4,5);
        Integer result = maximumDistanceFromCentrePoint(centrePoint, location);
        assertEquals(new Integer(2), result);
    }

    @Test
    public void maximumDistanceFromCentrePointTestOneTwoThree() throws Exception {
        Location location = new Location(1,2,3);
        Integer result = maximumDistanceFromCentrePoint(centrePoint, location);
        assertEquals(new Integer(4), result);
    }

    @Test
    public void getWeightedLocationMatrixQuantityAtOutSide() throws Exception {
        Map<Location, Integer> response = getWeightedQuantityLocationMatrix(centrePoint, 100, 4);
        Location testLocation = new Location(1,5,5);
        Integer actualQuantity = response.get(testLocation);
        assertEquals(new Integer(25), actualQuantity);
    }

    @Test
    public void getWeightedLocationMatrixQuantityNextToCentre() throws Exception {
        Map<Location, Integer> response = getWeightedQuantityLocationMatrix(centrePoint, 100, 4);
        Location testLocation = new Location(5,5,4);
        Integer actualQuantity = response.get(testLocation);
        assertEquals(new Integer(100), actualQuantity);
    }

    @Test
    public void getWeightedLocationMatrixQuantityAtOneTwoOne() throws Exception {
        Map<Location, Integer> response = getWeightedQuantityLocationMatrix(centrePoint, 100, 4);
        Location testLocation = new Location(1,2,1);
        Integer actualQuantity = response.get(testLocation);
        assertEquals(new Integer(25), actualQuantity);
    }

    @Test
    public void getWeightedLocationMatrixQuantityAtThreeThreeThree() throws Exception {
        Map<Location, Integer> response = getWeightedQuantityLocationMatrix(centrePoint, 100, 4);
        Location testLocation = new Location(3,3,3);
        Integer actualQuantity = response.get(testLocation);
        assertEquals(new Integer(50), actualQuantity);
    }

    private Integer cubeSizeCalculator(Integer spread) {
        Integer column = (spread  * 2) + 1;
        return column * column * column;
    }

}