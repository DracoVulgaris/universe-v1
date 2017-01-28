package com.universe.resources;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test the {@link Water} resource
 *
 * @since 21/01/2017.
 */
public class WaterTest {

    private Water water;

    @Before
    public void setUp() throws Exception {
        water = new Water();
        water.setQuantity(20);
    }

    @Test
    public void testConsume() throws Exception {
        water.consume(19);
        assertEquals("Water amount is incorrect", new Integer(1), water.quantity);
    }

    @Test
    public void testConsumeAll() throws Exception {
        water.consume(20);
        assertEquals("Water amount is incorrect", new Integer(0), water.quantity);
    }

    @Test
    public void consumeNone() throws Exception {
        water.consume(0);
        assertEquals("Water amount is incorrect", new Integer(20), water.quantity);
    }

    @Test
    public void consumeFulfillRequest() throws Exception {
        Integer test = water.consume(1);
        assertEquals("Water amount is incorrect", new Integer(1), test);
    }

    @Test
    public void consumeUnableToFulfillRequest() throws Exception {
        Integer test = water.consume(21);
        assertEquals("Water amount is incorrect", new Integer(20), test);
    }

}