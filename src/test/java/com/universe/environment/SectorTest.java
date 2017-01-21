package com.universe.environment;

import com.universe.elements.Food;
import com.universe.elements.Oxygen;
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
    private Oxygen oxygen = new Oxygen(75);
    private Water water = new Water(100);
    private Food food = new Food(10);

    @Before
    public void setUp() throws Exception {
        location = new Location(7, 1, 9);
        sector = new Sector(location);
    }

    @Test
    public void setSingleOxygen() throws Exception {
        sector.setOxygen(oxygen);
        assertNotNull("Oxygen in Sector is incorrect", sector.getOxygen());
    }

    @Test
    public void setNullOxygen() throws Exception {
        sector.setOxygen(null);
        assertNull("Oxygen in Sector is incorrect", sector.getOxygen());
    }

    @Test
    public void setMultipleOxygen() throws Exception {
        for (int x = 0; x < 10;++x) {
            Oxygen o = new Oxygen(x);
            sector.setOxygen(o);
        }
        assertEquals("Oxygen in Sector is incorrect", new Integer(10), sector.getResourceCount().get("Oxygen"));
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