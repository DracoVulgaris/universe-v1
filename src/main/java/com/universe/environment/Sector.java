package com.universe.environment;

import com.universe.elements.Food;
import com.universe.elements.Oxygen;
import com.universe.elements.Resource;
import com.universe.elements.Water;

import java.util.*;

/**
 * A container at a given width, height and depth in the {@link Universe} that has varying amounts of
 * {@link com.universe.elements.Resource}s
 *
 * @since 21/01/2017.
 */
public class Sector {
    private final Location location;

    private Stack<Oxygen> totalOxygen = new Stack<>();
    private Stack<Water> totalWater = new Stack<>();
    private Stack<Food> totalFood = new Stack<>();

    Sector(Location location) {
        this.location = location;
    }


    /**
     * Get a single {@link Oxygen} resource from this Sector if there is any
      * @return an Oxygen resource if this Sector has any otherwise <code>null</code>
     */
    Oxygen getOxygen() {
        Oxygen oxygen = null;
        if (totalOxygen.size() > 0) {
            oxygen = totalOxygen.pop();
        }
        return oxygen;
    }

    /**
     * Add an {@link Oxygen} resource to this Sector
     * @param oxygen a single Oxygen resource
     */
    void setOxygen(Oxygen oxygen) {
        this.totalOxygen.push(oxygen);
    }

    /**
     * Get a single {@link Water} resource from this Sector if there is any
     * @return an Water resource if this Sector has any otherwise <code>null</code>
     */
    public Water getWater() {
        Water water = null;
        if (totalWater.size() > 0) {
            water = totalWater.pop();
        }
        return water;
    }

    /**
     * Add an {@link Water} resource to this Sector
     * @param water a single Oxygen resource
     */
    public void setWater(Water water) {
        this.totalWater.push(water);
    }

    /**
     * Get a single {@link Food} resource from this Sector if there is any
     * @return an Oxygen resource if this Sector has any otherwise <code>null</code>
     */
    public Food getFood() {
        Food food = null;
        if (totalFood.size() > 0) {
            food = totalFood.pop();
        }
        return food;
    }

    /**
     * Add an {@link Food} resource to this Sector
     * @param food a single Oxygen resource
     */
    public void setFood(Food food) {
        this.totalFood.push(food);
    }

    /**
     * Get the width, heith and depth dimensions of this Sector
     * @return the Location of this Sector
     */
    Location getLocation() {
        return location;
    }

    /**
     * The amount of each of the resources available in this Sector keyed by the resource name.
     * @return a map of the number of resources available
     */
    Map<String, Integer> getResourceCount() {
        Map<String, Integer> resources = new HashMap<>();
        resources.put("Oxygen", totalOxygen.size());
        resources.put("Water", totalWater.size());
        resources.put("Food", totalFood.size());
        return resources;
    }


    @Override
    public String toString() {
       return "Sector (" + location + ")\n"
               + "Oxygen: " + totalOxygen.size() + "\n"
               + "Water: " + totalWater.size() + "\n"
               + "Food: " + totalFood.size() + "\n";
    }
}
