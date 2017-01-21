package com.universe.environment;

import com.universe.exceptions.LocationException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @since 21/01/2017.
 */
public class LocationTest {

    private Location location;

    @Before
    public void setUp() throws Exception {
        location = new Location(9, 3, 7);
    }

    @Test
    public void testGetWidth() throws Exception {
        assertEquals("Location width is incorrect", new Integer(9), location.getWidth());
    }

    @Test
    public void testGetHeight() throws Exception {
        assertEquals("Location height is incorrect", new Integer(3), location.getHeight());
    }

    @Test
    public void testGetDepth() throws Exception {
        assertEquals("Location depth is incorrect", new Integer(7), location.getDepth());
    }

    @Test (expected=LocationException.class)
    public void testException() throws Exception {
        Location oops = new Location(Location.WIDTH, 0, 7);
    }

}