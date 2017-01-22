package com.universe.environment;

import com.universe.elements.Food;
import com.universe.elements.Oxygen;
import com.universe.elements.Resource;
import com.universe.elements.Water;

import java.util.*;

/**
 * A container at a given {@link Location} in the {@link Universe} that has varying amounts of
 * {@link Resource}s
 *
 * @since 21/01/2017.
 */
public class Sector {
    private final Location location;

    private Oxygen oxygen = new Oxygen();
    private Water water = new Water();
    private Food food = new Food();

    Sector(Location location) {
        this.location = location;
    }

    /**
     * Get the width, heith and depth dimensions of this Sector
     * @return the Location of this Sector
     */
    Location getLocation() {
        return location;
    }

    /**
     * The resources available in this Sector keyed by the Resource name.
     * @return a map of the number of resources available
     */
    Map<String, Resource> getResources() {
        Map<String, Resource> resources = new HashMap<>();
        resources.put(oxygen.getResourceName(), oxygen);
        resources.put(water.getResourceName(), water);
        resources.put(food.getResourceName(), food);
        return resources;
    }


    @Override
    public String toString() {
       return "Sector (" + location + ")\n"
               + oxygen + "\n"
               + water + "\n"
               + food + "\n";
    }
}
