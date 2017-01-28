package com.universe.pollution;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests the {@link Excrement} pollution
 *
 * @since 28/01/2017.
 */
public class ExcrementTest {

    private Excrement excrement;

    @Before
    public void setUp() throws Exception {
        excrement = new Excrement();
    }

    @Test
    public void excrementPollutionTest() throws Exception {
        excrement.produce(34);
        assertEquals(new Integer(34), excrement.getQuantity());
    }

    @Test
    public void getPollutionName() throws Exception {
        assertEquals("Excrement", excrement.getPollutionName());
    }

}