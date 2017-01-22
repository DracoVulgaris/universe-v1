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

    private PropertiesManager manager;

    @Before
    public void setUp() throws Exception {
        manager = new PropertiesManager("universe.properties");
    }

    @Test
    public void getUniversePropertyNotNull() throws Exception {
        String test = manager.getUniverseProperty(PropertyKeys.WIDTH.key());
        assertNotNull(test);
    }

    @Test
    public void getUniversePropertyIsNull() throws Exception {
        String test = manager.getUniverseProperty("FRED");
        assertNull(test);
    }

    @Test
    public void getUniversePropertyValue() throws Exception {
        String test = manager.getUniverseProperty(PropertyKeys.DEPTH.key());
        assertEquals("Property is incorrect", "10", test);
    }
}