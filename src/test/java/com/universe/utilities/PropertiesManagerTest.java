package com.universe.utilities;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test the {@link PropertiesManager}
 *
 * @since 22/01/2017.
 */
public class PropertiesManagerTest {

    //private PropertiesManager manager;

    @Before
    public void setUp() throws Exception {
        //manager = PropertiesManager.getInstance("universe.properties");
    }

    @Test
    public void getUniversePropertyNotNull() throws Exception {
        String test = PropertiesManager.getUniverseProperty(PropertyKeys.WIDTH.key());
        assertNotNull(test);
    }

    @Test
    public void getUniversePropertyIsNull() throws Exception {
        String test = PropertiesManager.getUniverseProperty("FRED");
        assertNull(test);
    }

    @Test
    public void getUniversePropertyValue() throws Exception {
        String test = PropertiesManager.getUniverseProperty(PropertyKeys.DEPTH.key());
        assertEquals("Property is incorrect", "10", test);
    }
}