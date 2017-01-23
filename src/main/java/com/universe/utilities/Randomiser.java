package com.universe.utilities;

import com.universe.environment.Location;
import com.universe.exceptions.LocationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * Get random values for adding chaos to the Universe
 *
 * @since 21/01/2017.
 */
public class Randomiser {

    private static Logger log = LoggerFactory.getLogger(Randomiser.class);

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

    /**
     * Get a {@link Location} that is at a random point but is guaranteed to be within the bounds of
     * the {@link com.universe.environment.Universe}
     * @return a randomly positioned {@link Location}
     * @throws LocationException thrown if location is outside the bounds of the {@link com.universe.environment.Universe}
     */
    public static Location getRandomLocation() throws LocationException {

        //establish the bounds of the Universe
        final Integer WIDTH_OF_UNIVERE = PropertiesManager.UNIVERSE_MAX_WIDTH;
        final Integer HEIGHT_OF_UNIVERE = PropertiesManager.UNIVERSE_MAX_HEIGHT;
        final Integer DEPTH_OF_UNIVERE = PropertiesManager.UNIVERSE_MAX_DEPTH;

        Integer randomWidth = getRandomBoundedInteger(WIDTH_OF_UNIVERE);
        Integer randomHeight = getRandomBoundedInteger(HEIGHT_OF_UNIVERE);
        Integer randomDepth = getRandomBoundedInteger(DEPTH_OF_UNIVERE);

        return new Location(randomWidth, randomHeight, randomDepth);
    }
}
