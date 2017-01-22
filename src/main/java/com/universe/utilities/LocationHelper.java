package com.universe.utilities;

import com.universe.environment.Location;
import com.universe.exceptions.LocationException;
import com.universe.exceptions.UniverseException;

import java.util.HashMap;
import java.util.Map;

/**
 * Helper functions to plot {@link com.universe.environment.Location}s
 *
 * @since 22/01/2017.
 */
public class LocationHelper {

    /**
     * Creates a matrix of {@link Location}s that with a known centre and that extends out to the spread number in all
     * directions. The quantity associated with each Location is proportionally less the further the Location is from
     * the centre.
     * @param centrePoint the centre of the matrix
     * @param maximumQuantity the maximum quantity that can be associated with a Location. The centre point Location always
     *                        gets the maximum quantity
     * @param spread how far the matrix entends from the centre point
     * @return a {@link Map} of quantities keyed by {@link Location}
     * @throws UniverseException thrown if unable to load the {@link com.universe.environment.Universe}s properties
     * @throws LocationException thrown if unable to create a {@link Location}
     */
    public static Map<Location, Integer> getWeightedLocationMatrix(Location centrePoint, Integer maximumQuantity, Integer spread) throws UniverseException, LocationException {
        Map<Location, Integer> matrix = new HashMap<>();

        //always add the centrePoint Location and it always gets maximumQuantity even if that is zero
        matrix.put(centrePoint, maximumQuantity);

        //don't bother calculating if either maximumQuantity or spread is zero as the
        if (spread.equals(0) || maximumQuantity.equals(0)) {
            return matrix;
        }

        PropertiesManager propertiesManager = new PropertiesManager();
        final Integer WIDTH_OF_UNIVERSE = new Integer(propertiesManager.getUniverseProperty(PropertyKeys.WIDTH.key()));
        final Integer HEIGHT_OF_UNIVERSE = new Integer(propertiesManager.getUniverseProperty(PropertyKeys.HEIGHT.key()));
        final Integer DEPTH_OF_UNIVERSE = new Integer(propertiesManager.getUniverseProperty(PropertyKeys.DEPTH.key())) ;

        Integer minWidth = centrePoint.getWidth() - spread > 0 ? centrePoint.getWidth() - spread : 0;
        Integer maxWidth = centrePoint.getWidth() + spread < WIDTH_OF_UNIVERSE ? centrePoint.getWidth() + spread : WIDTH_OF_UNIVERSE - 1;

        Integer minHeight = centrePoint.getHeight() - spread > 0 ? centrePoint.getHeight() - spread : 0;
        Integer maxHeight = centrePoint.getHeight() + spread < HEIGHT_OF_UNIVERSE ? centrePoint.getHeight() + spread : HEIGHT_OF_UNIVERSE - 1;

        Integer minDepth = centrePoint.getDepth() - spread > 0 ? centrePoint.getDepth() - spread : 0;
        Integer maxDepth = centrePoint.getDepth() + spread < DEPTH_OF_UNIVERSE ? centrePoint.getDepth() + spread : DEPTH_OF_UNIVERSE - 1;


        for (int x = minWidth; x <= maxWidth; ++x) {
            for (int y = minHeight; y <= maxHeight; ++y) {
                for (int z = minDepth; z <= maxDepth; ++z) {
                    Location xyz = new Location(x,y,z);
                    Integer distanceFromCentre = maximumDistanceFromCentrePoint(centrePoint, xyz);
                    Integer weightedQuantity = distanceFromCentre.equals(0) ? 0 : maximumQuantity / distanceFromCentre;
                    matrix.put(xyz, weightedQuantity);
                }
            }
        }

        return matrix;
    }

    /**
     * Calculates the maximum distance of any of width, heith or depth dimension from the same dimensions of a nominated
     * centre point
     * @param centrePoint the reference point to caluclate distance from
     * @param testLocation the {@link Location} to get the maximum distance from
     * @return the absolute maximum distance of any dimension from the centre point
     */
    public static Integer maximumDistanceFromCentrePoint(Location centrePoint, Location testLocation) {

        Integer centreWidth = centrePoint.getWidth();
        Integer centreHeight = centrePoint.getHeight();
        Integer centreDepth = centrePoint.getDepth();

        Integer testLocationWidth = testLocation.getWidth();
        Integer testLocationHeight = testLocation.getHeight();
        Integer testLocationDepth = testLocation.getDepth();

        Integer widthDifference = Math.abs(centreWidth - testLocationWidth);
        Integer heightDifference = Math.abs(centreHeight - testLocationHeight);
        Integer depthDifference = Math.abs(centreDepth - testLocationDepth);

        return Math.max(Math.max(widthDifference, heightDifference), depthDifference);
    }
}
