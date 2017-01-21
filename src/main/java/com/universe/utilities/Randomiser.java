package com.universe.utilities;

import java.util.Random;

/**
 * Get random values for adding chaos to the Universe
 *
 * @since 21/01/2017.
 */
public class Randomiser {

    private static Random random = new Random(System.currentTimeMillis());

    public static Integer getRandomInteger() {
        return random.nextInt();
    }

    public static Integer getRandomBoundedInteger(Integer max) {
        return random.nextInt(max);
    }

    public static Float getRandomFloatBetweenZeroAndOne() {
        return random.nextFloat();
    }
}
