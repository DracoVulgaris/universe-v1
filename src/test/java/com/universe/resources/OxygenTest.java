package com.universe.resources;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test the {@link Oxygen} resource
 *
 * @since 21/01/2017.
 */
public class OxygenTest {

    private Oxygen oxygen;

    @Before
    public void setUp() {
        oxygen = new Oxygen();
        oxygen.setQuantity(6);
    }

    @Test
    public void testConsume() throws Exception {
        oxygen.consume(1);
        assertEquals("Oxygen amount is incorrect", new Integer(5), oxygen.quantity);
    }

    @Test
    public void testConsumeAll() throws Exception {
        oxygen.consume(999);
        assertEquals("Oxygen amount is incorrect", new Integer(0), oxygen.quantity);
    }

    @Test
    public void consumeNone() throws Exception {
        oxygen.consume(0);
        assertEquals("Water amount is incorrect", new Integer(6), oxygen.quantity);
    }

    @Test
    public void consumeFulfillRequest() throws Exception {
        Integer test = oxygen.consume(6);
        assertEquals("Oxygen amount is incorrect", new Integer(6), test);
    }

    @Test
    public void consumeUnableToFulfillRequest() throws Exception {
        Integer test = oxygen.consume(7);
        assertEquals("Oxygen amount is incorrect", new Integer(6), test);
    }

}