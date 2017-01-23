package com.universe.utilities;

import com.universe.environment.Location;
import org.junit.Test;

import static org.junit.Assert.*;
import static com.universe.utilities.Randomiser.*;

/**
 * @since 21/01/2017.
 */
public class RandomiserTest {
    @Test
    public void getRandomIntegerTestNotNull() throws Exception {
        assertNotNull(getRandomInteger());
    }

    @Test
    public void getRandomBoundedIntegerTest() throws Exception {
        assertTrue(getRandomBoundedInteger(10) < 10);
    }

    @Test
    public void getRandomLargeBoundedIntegerTest() throws Exception {
        assertTrue(getRandomBoundedInteger(1000000) < 1000000);
    }

    @Test
    public void getRandomFloatBetweenZeroAndOneNotNullTest() throws Exception {
        assertNotNull(getRandomFloatBetweenZeroAndOne());
    }

    @Test
    public void getRandomFloatBetweenZeroAndOneTest() throws Exception {
        assertTrue(getRandomFloatBetweenZeroAndOne() <= 1.0F);
    }

    @Test
    public void getRandomLocationTest() throws Exception {
        assertNotNull(getRandomLocation());
    }

    @Test
    public void getRandomLocationBoundsTest() throws Exception {

        //to really test this, we'll generate 1000 locations randomly
        for (int x = 0; x < 1000; ++x) {
            Location testLocation = getRandomLocation();
            assertTrue(testLocation.getWidth() < PropertiesManager.UNIVERSE_MAX_WIDTH);
            assertTrue(testLocation.getHeight() < PropertiesManager.UNIVERSE_MAX_HEIGHT);
            assertTrue(testLocation.getDepth() < PropertiesManager.UNIVERSE_MAX_DEPTH);
        }
    }
}