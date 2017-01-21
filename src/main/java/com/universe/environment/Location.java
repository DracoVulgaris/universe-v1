package com.universe.environment;

import com.universe.exceptions.LocationException;
import com.universe.settings.UniverseConfiguration;

/**
 * The width, height and depth dimensions of a {@link Sector}
 *
 * @since 21/01/2017.
 */
public class Location implements UniverseConfiguration {

    private Integer width;
    private Integer height;
    private Integer depth;

    public Location(Integer width, Integer height, Integer depth) throws LocationException {
        if (width > WIDTH - 1 || height > HEIGHT - 1 || depth > DEPTH - 1) {
            String message = "The location (" + width + ", " + height + ", " + depth + ") is outside the boundary of the Universe.";
            throw new LocationException(message);
        }
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    Integer getWidth() {
        return width;
    }

    Integer getHeight() {
        return height;
    }

    Integer getDepth() {
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
        return (this.hashCode()  + width.hashCode() + height.hashCode() + depth.hashCode());
    }

    @Override
    public String toString() {
        return width + ", " + height + ", " + depth;
    }

}
