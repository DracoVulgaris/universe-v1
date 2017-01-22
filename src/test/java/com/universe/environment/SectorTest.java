package com.universe.environment;

import com.universe.elements.Food;
import com.universe.elements.Oxygen;
import com.universe.elements.Resource;
import com.universe.elements.Water;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @since 21/01/2017.
 */
public class SectorTest {

    private Sector sector;
    private Location location;
    private Oxygen oxygen = new Oxygen();
    private Water water = new Water();
    private Food food = new Food();

    @Before
    public void setUp() throws Exception {
        location = new Location(7, 1, 9);
        sector = new Sector(location);
        oxygen.setQuantity(75);
        water.setQuantity(100);
        food.setQuantity(10);
    }

    @Test
    public void getResources() throws Exception {
        assertNotNull("Resources in Sector is incorrect", sector.getResources());
    }

    @Test
    public void getResource() throws Exception {
        Resource test = sector.getResources().get("Oxygen");
        assertNotNull("Oxygen in Sector is incorrect", test);
    }


    @Test
    public void getLocation() throws Exception {
        Location test = sector.getLocation();
        assertNotNull(test);
    }

    @Test
    public void getLocationDimensions() throws Exception {
        Location test = sector.getLocation();
        assertEquals("Location is incorrect in Sector", location, test);
    }

}