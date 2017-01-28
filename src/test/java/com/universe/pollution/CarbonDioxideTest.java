package com.universe.pollution;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests the {@link Excrement} pollution
 *
 * @since 28/01/2017.
 */
public class CarbonDioxideTest {

    private CarbonDioxide carbonDioxide;

    @Before
    public void setUp() throws Exception {
        carbonDioxide = new CarbonDioxide();
    }

    @Test
    public void carbonDioxidePollutionTest() throws Exception {
        carbonDioxide.produce(3);
        assertEquals(new Integer(3), carbonDioxide.getQuantity());
    }

    @Test
    public void getPollutionName() throws Exception {
        assertEquals("Carbon Dioxide", carbonDioxide.getPollutionName());
    }

}