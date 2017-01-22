package com.universe.utilities;

import com.universe.exceptions.UniverseException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Helper functions to retrieve, update and persist various properties associated with the {@link com.universe.environment.Universe}
 *
 * @since 22/01/2017.
 */
public class PropertiesManager {

    private Properties universeProperties = new Properties();

    /**
     * Create the Properties manager using the default location of the properties files
     * @throws UniverseException unable to create Universe
     */
    public PropertiesManager() throws UniverseException {
        loadUniverseProperties();
    }

    /**
     * Create the Properties manager using the supplied locations of the properties files
     * @param universePropertiesPath the path to the <code>universe.properties</code> file
     * @throws UniverseException unable to create Universe
     */
    public PropertiesManager(String universePropertiesPath) throws UniverseException {
        loadUniverseProperties(universePropertiesPath);
    }

    /**
     * Retrieve a specified property from the immutable set of properties associated with initialising the {@link com.universe.environment.Universe}
     * @param key the key associated with the property
     * @return the valuse associated with the key
     */
    public String getUniverseProperty(String key) {
        return universeProperties.getProperty(key);
    }

    /**
     * Populate the immutable list of properties needed to create the {@link com.universe.environment.Universe}
     * @throws UniverseException unable to create Universe
     */
    private void loadUniverseProperties() throws UniverseException {
        try {
            InputStream resourceStream = getClass().getClassLoader().getResourceAsStream("universe.properties");
            universeProperties.load(resourceStream);
        } catch (IOException e) {
            throw new UniverseException(e.getMessage(), e);
        }
    }

    /**
     * Populate the immutable list of properties needed to create the {@link com.universe.environment.Universe}
     * @param path the location of the properties file
     * @throws UniverseException unable to create Universe
     */
    private void loadUniverseProperties(String path) throws UniverseException {
        try {
            InputStream resourceStream = getClass().getClassLoader().getResourceAsStream(path);
            universeProperties.load(resourceStream);
        } catch (IOException e) {
            throw new UniverseException(e.getMessage(), e);
        }
    }
}
