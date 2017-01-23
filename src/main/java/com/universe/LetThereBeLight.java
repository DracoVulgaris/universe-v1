package com.universe;


import com.universe.environment.Location;
import com.universe.environment.Sector;
import com.universe.environment.Universe;
import com.universe.exceptions.LocationException;
import com.universe.exceptions.UniverseException;
import com.universe.utilities.PropertiesManager;
import com.universe.utilities.PropertyKeys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.universe.utilities.DateUtilities.getFormattedCurrentDateTime;

/**
 * The main class used to drive the creation of the Universe simulation.
 *
 * @since 21/01/2017.
 */
public class LetThereBeLight {

    private static Logger log = LoggerFactory.getLogger(LetThereBeLight.class);

    public static void main(String[] args) {
        log.debug("START: " + getFormattedCurrentDateTime());

        try {
            Universe universe = new Universe();
            Sector alpha = universe.getSector(new Location(0,0,0));
            Sector omega = universe.getSector(new Location(new Integer(PropertiesManager.getUniverseProperty(PropertyKeys.WIDTH.key())) - 1 ,
                    new Integer(PropertiesManager.getUniverseProperty(PropertyKeys.HEIGHT.key())) -1,
                    new Integer(PropertiesManager.getUniverseProperty(PropertyKeys.DEPTH.key())) -1));
            log.info("Alpha Sector: " + alpha.toString());
            log.info("Omega Sector: " + omega.toString());
        } catch (LocationException | UniverseException e) {
            log.error(e.getMessage(), e);
        }
        log.debug("END: " + getFormattedCurrentDateTime());
    }
}
