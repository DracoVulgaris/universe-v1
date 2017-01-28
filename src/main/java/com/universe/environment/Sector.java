package com.universe.environment;

import com.universe.pollution.CarbonDioxide;
import com.universe.pollution.Excrement;
import com.universe.pollution.Pollution;
import com.universe.resources.Food;
import com.universe.resources.Oxygen;
import com.universe.resources.Resource;
import com.universe.resources.Water;

import java.util.HashMap;
import java.util.Map;

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

    private CarbonDioxide carbonDioxide = new CarbonDioxide();
    private Excrement excrement = new Excrement();

    Sector(Location location) {
        this.location = location;
    }

    /**
     * Get the width, height and depth dimensions of this Sector
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

    /**
     * The pollution present in this Sector keyed by the Pollution name.
     * @return a map of the amount of pollution present
     */
    Map<String, Pollution> getPollution() {
        Map<String, Pollution> pollution = new HashMap<>();
        pollution.put(carbonDioxide.getPollutionName(), carbonDioxide);
        pollution.put(excrement.getPollutionName(), excrement);
        return pollution;
    }


    @Override
    public String toString() {
       return "Sector (" + location + ")\n"
               + oxygen + "\n"
               + water + "\n"
               + food + "\n"
               + carbonDioxide + "\n"
               + excrement + "\n";
    }
}
