package com.universe.environment;

import com.universe.exceptions.UniverseException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test of the <link>Universe</link> class
 *
 * @since 21/01/2017.
 */
public class UniverseTest {

    private Universe universe;

    @Before
    public void setUp() throws Exception {
        universe = new Universe();
    }

    @Test
    public void testGetSectorNotNull() throws Exception {
        Sector threeFourFive = universe.getSector(3, 4, 5);
        assertNotNull(threeFourFive);
    }

    @Test
    public void testGetSectorOneTwoThree() throws Exception {
        Sector oneTwoThree = universe.getSector(1, 2, 3);
        Location location = oneTwoThree.getLocation();
        assertEquals("Expected sector one, two, three", new Integer(1), location.getWidth());
        assertEquals("Expected sector one, two, three", new Integer(2), location.getHeight());
        assertEquals("Expected sector one, two, three", new Integer(3), location.getDepth());
    }

    @Test(expected=UniverseException.class)
    public void testGetSectorOutOfBounds() throws Exception {
        Sector oops = universe.getSector(Universe.WIDTH, 2, 3);
    }

}