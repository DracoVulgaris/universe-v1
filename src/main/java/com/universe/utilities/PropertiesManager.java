package com.universe.utilities;

import com.universe.exceptions.PropertiesException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Helper functions to retrieve, update and persist various properties associated with the {@link com.universe.environment.Universe}
 *
 * @since 22/01/2017.
 */
public class PropertiesManager {

    static {
        try {
            loadUniverseProperties();
            popluateConstants();
        } catch (PropertiesException e) {
            //fatal error as everthing depend on this so just die
            System.exit(1);
        }
    }

    private static Properties universeProperties;

    public static Integer UNIVERSE_MAX_WIDTH;
    public static Integer UNIVERSE_MAX_HEIGHT;
    public static Integer UNIVERSE_MAX_DEPTH;

    private static void popluateConstants() {
        UNIVERSE_MAX_WIDTH = new Integer(getUniverseProperty(PropertyKeys.WIDTH.key()));
        UNIVERSE_MAX_HEIGHT = new Integer(getUniverseProperty(PropertyKeys.HEIGHT.key()));
        UNIVERSE_MAX_DEPTH = new Integer(getUniverseProperty(PropertyKeys.DEPTH.key()));
    }


    /**
     * Retrieve a specified property from the immutable set of properties associated with initialising the {@link com.universe.environment.Universe}
     * @param key the key associated with the property
     * @return the valuse associated with the key
     */
    public static String getUniverseProperty(String key) {
        return universeProperties.getProperty(key);
    }

    /**
     * Populate the immutable list of properties needed to create the {@link com.universe.environment.Universe}
     * @throws PropertiesException unable to load Properties
     */
    private static void loadUniverseProperties() throws PropertiesException {
        try {
            universeProperties = new Properties();
            InputStream resourceStream = PropertiesManager.class.getClassLoader().getResourceAsStream("universe.properties");
            universeProperties.load(resourceStream);
        } catch (IOException e) {
            throw new PropertiesException(e.getMessage(), e);
        }
    }
}
