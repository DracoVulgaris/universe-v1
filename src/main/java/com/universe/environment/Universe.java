package com.universe.environment;

import com.universe.exceptions.LocationException;
import com.universe.exceptions.UniverseException;
import com.universe.utilities.PropertiesManager;
import com.universe.utilities.PropertyKeys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * The sandbox container that holds everything. The size of the Universe is set by the width, height and depth dimensions
 * that are in the <code>universe.properties</code> file. The Universe is filled with {@link Sector}s.
 *
 * @since 21/01/2017.
 */
public class Universe {

    private List<List<List<List<Sector>>>> universe = new ArrayList<>();
    private PropertiesManager propertiesManager;
    private final Integer WIDTH;
    private final Integer HEIGHT;
    private final Integer DEPTH;
    private Logger log = LoggerFactory.getLogger(this.getClass());


    public Universe() throws UniverseException, LocationException {
        propertiesManager = new PropertiesManager();
        WIDTH = new Integer(propertiesManager.getUniverseProperty(PropertyKeys.WIDTH.key()));
        HEIGHT = new Integer(propertiesManager.getUniverseProperty(PropertyKeys.HEIGHT.key()));
        DEPTH = new Integer(propertiesManager.getUniverseProperty(PropertyKeys.DEPTH.key()));
        build();
        log.debug("Universe has been created");
    }

    private void build() throws UniverseException, LocationException {
        for (int x = 0; x < WIDTH; ++x) {
            List<List<List<Sector>>> width = new ArrayList<>();
            for (int y = 0; y < HEIGHT; ++y) {
                List<List<Sector>> height = new ArrayList<>();
                for (int z = 0; z < DEPTH; ++z) {
                    List<Sector> depth = new ArrayList<>();
                    Sector sector = new Sector(new Location(x, y, z));
                    depth.add(sector);
                    height.add(z, depth);
                }
                width.add(y, height);
            }
            universe.add(x, width);
        }
    }

    /**
     * Returns a sector at a given location in the {@link Universe}
     * @param location the width, height and depth
     * @return the Sector at the given location
     */
    public Sector getSector(Location location) {
        return universe.get(location.getWidth()).get(location.getHeight()).get(location.getDepth()).get(0);
    }
}
