package com.universe;


import com.universe.environment.Sector;
import com.universe.environment.Universe;
import com.universe.exceptions.UniverseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The main class used to drive the creation of the Universe simulation.
 *
 * @since 21/01/2017.
 */
public class LetThereBeLight {

    private static Logger log = LoggerFactory.getLogger(LetThereBeLight.class);

    public static void main(String[] args) {
        log.debug("START");
        Universe universe = new Universe();
        try {
            Sector alpha = universe.getSector(0,0,0);
            Sector omega = universe.getSector(Universe.WIDTH -1 , Universe.HEIGHT -1, Universe.DEPTH -1);
            log.info("Alpha Sector: " + alpha.toString());
            log.info("Omega Sector: " + omega.toString());
        } catch (UniverseException e) {
            log.error("Error getting sector.", e);
        }
        log.debug("END");
    }
}
