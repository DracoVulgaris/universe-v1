package com.universe.environment;

import com.universe.exceptions.UniverseException;
import com.universe.settings.UniverseConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/*
 * The sandbox container that holds everything. The size of the Universe is set by the width, height and depth dimensions
 * that are in the {@link UniverseConfiguration} interface. The Universe is filled with {@link Sector}s.
 *
 * @since 21/01/2017.
 */
public class Universe implements UniverseConfiguration {

    private List<List<List<List<Sector>>>> universe = new ArrayList<>();

    private Logger log = LoggerFactory.getLogger(this.getClass());


    public Universe() {
        build();
        log.debug("Universe has been created");
    }

    private void build() {
        for (int x = 0; x < WIDTH; ++x) {
            List<List<List<Sector>>> width = new ArrayList<>();
            for (int y = 0; y < HEIGHT; ++y) {
                List<List<Sector>> height = new ArrayList<>();
                for (int z = 0; z < DEPTH; ++z) {
                    List<Sector> depth = new ArrayList<>();
                    Sector s = new Sector (x, y, z);
                    depth.add(s);
                    height.add(z, depth);
                }
               width.add(y, height);
            }
            universe.add(x, width);
        }
    }

    /**
     * Returns a sector at a given location in the {@link Universe}
     * @param width the X dimension in the Universe
     * @param height the Y domension in the Universe
     * @param depth the Z dimension in the Universe
     * @return the {@link Sector} at the X, Y, Z coordinates provided
     * @throws UniverseException the requested sector is outside the universe
     */
    public Sector getSector(Integer width, Integer height, Integer depth) throws UniverseException {
        if (width >= WIDTH || height >= HEIGHT || depth >= DEPTH) {
            String message = "\nRequested sector (width: " + width + ", height: " + height + ", depth: " + depth + ") is outside the Universe.\n"
                    + "Universe dimensions are width: " + WIDTH + " height: " + HEIGHT + " depth: " + DEPTH + "\n"
                    + "Remember the Universe is zero indexed.";
            throw new UniverseException(message);
        }
        return universe.get(width).get(height).get(depth).get(0);
    }
}
