package com.universe.environment;

import com.universe.pollution.Pollution;
import com.universe.resources.Resource;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @since 21/01/2017.
 */
public class SectorTest {

    private Sector sector;
    private Location location;

    @Before
    public void setUp() throws Exception {
        location = new Location(7, 1, 9);
        sector = new Sector(location);
        sector.getResources().get("Oxygen").setQuantity(75);
        sector.getResources().get("Food").setQuantity(10);
        sector.getResources().get("Water").setQuantity(100);
        sector.getPollution().get("Excrement").produce(67);
        sector.getPollution().get("Carbon Dioxide").produce(120);
    }

    @Test
    public void getResources() throws Exception {
        assertNotNull("Resources in Sector is incorrect", sector.getResources());
    }

    @Test
    public void getResource() throws Exception {
        Resource test = sector.getResources().get("Oxygen");
        assertNotNull("Oxygen in Sector is incorrect", test);
        assertEquals(new Integer(75), test.consume(150));
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

    @Test
    public void getPollution() throws Exception {
        assertNotNull("Pollution in Sector is incorrect", sector.getPollution());
    }

    @Test
    public void getPollutionCO2() throws Exception {
        Pollution test = sector.getPollution().get("Carbon Dioxide");
        assertNotNull("Carbon Dioxide in Sector is incorrect", test);
        assertEquals(new Integer(120), test.getQuantity());
    }

}