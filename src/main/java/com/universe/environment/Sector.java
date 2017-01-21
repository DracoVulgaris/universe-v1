package com.universe.environment;

/**
 * A container at a given width, height and depth in the {@link Universe}
 *
 * @since 21/01/2017.
 */
public class Sector {
    private final Integer width;
    private final Integer height;
    private final Integer depth;

    Sector(Integer width, Integer height,Integer depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    @Override
    public String toString() {
       return "Sector:- width: " + width.toString() + " height: " + height.toString() + " depth: " + depth.toString();
    }
}
