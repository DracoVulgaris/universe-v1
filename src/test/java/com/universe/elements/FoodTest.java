package com.universe.elements;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test the {@link Food} resource
 *
 * @since 21/01/2017.
 */
public class FoodTest  {
    private Food food;

    @Before
    public void setUp() throws Exception {
        food = new Food(100);
    }

    @Test
    public void testConsumeQuantityLeft() throws Exception {
        food.consume(50);
        assertEquals("Food amount is incorrect", new Integer(50), food.quantity);
    }

    @Test
    public void testConsumeAll() throws Exception {
        food.consume(999);
        assertEquals("Food amount is incorrect", new Integer(0), food.quantity);
    }

    @Test
    public void consumeNone() throws Exception {
        food.consume(0);
        assertEquals("Food amount is incorrect", new Integer(100), food.quantity);
    }

    @Test
    public void consumeFulfillRequest() throws Exception {
        Integer test = food.consume(30);
        assertEquals("Food amount is incorrect", new Integer(30), test);
    }

    @Test
    public void consumeUnableToFulfillRequest() throws Exception {
        Integer test = food.consume(160);
        assertEquals("Food amount is incorrect", new Integer(100), test);
    }

}