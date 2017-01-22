package com.universe.environment;

import com.universe.exceptions.LocationException;
import com.universe.utilities.PropertiesManager;
import com.universe.utilities.PropertyKeys;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Test of the <link>Universe</link> class
 *
 * @since 21/01/2017.
 */
public class UniverseTest {

    private Universe universe;
    private PropertiesManager p;

    @Before
    public void setUp() throws Exception {
        p = new PropertiesManager();
        universe = new Universe();
    }

    @Test
    public void testGetSectorNotNull() throws Exception {
        Location location = new Location(3, 4, 5);
        Sector threeFourFive = universe.getSector(location);
        assertNotNull(threeFourFive);
    }

    @Test
    public void testGetSectorOneTwoThree() throws Exception {
        Location locationRequest = new Location(1, 2, 3);
        Sector oneTwoThree = universe.getSector(locationRequest);
        Location location = oneTwoThree.getLocation();
        assertEquals("Expected sector one, two, three", new Integer(1), location.getWidth());
        assertEquals("Expected sector one, two, three", new Integer(2), location.getHeight());
        assertEquals("Expected sector one, two, three", new Integer(3), location.getDepth());
    }

    @Test(expected=LocationException.class)
    public void testGetSectorOutOfBounds() throws Exception {
        Integer width = new Integer(p.getUniverseProperty(PropertyKeys.WIDTH.key()));
        Location location = new Location(width, 2, 3);
        Sector oops = universe.getSector(location);
    }

}