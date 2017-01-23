package com.universe.environment;

import com.universe.exceptions.LocationException;
import com.universe.utilities.PropertiesManager;

/**
 * The width, height and depth (x, y, z) coordinates of a {@link Sector}
 *
 * @since 21/01/2017.
 */
public class Location {

    private Integer width;
    private Integer height;
    private Integer depth;

    public Location(Integer width, Integer height, Integer depth) throws LocationException {
        Integer universeMaxWidth = PropertiesManager.UNIVERSE_MAX_WIDTH;
        Integer universeMaxHeight = PropertiesManager.UNIVERSE_MAX_HEIGHT;
        Integer universeMaxDepth = PropertiesManager.UNIVERSE_MAX_DEPTH;
        if (width > universeMaxWidth - 1 || height > universeMaxHeight - 1 || depth > universeMaxDepth - 1) {
            String message = "The location (" + width + ", " + height + ", " + depth + ") is outside the boundary of the Universe.";
            throw new LocationException(message);
        }
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getDepth() {
        return depth;
    }

    @Override
    public boolean equals(Object other) {
            return other instanceof Location
                    && ((Location) other).getWidth().equals(this.width)
                    && ((Location) other).getHeight().equals(this.height)
                    && ((Location) other).getDepth().equals(this.depth);
    }

    @Override
    public int hashCode() {
        return (width.hashCode() + height.hashCode() + depth.hashCode()) * 31;
    }

    @Override
    public String toString() {
        return width + ", " + height + ", " + depth;
    }

}
