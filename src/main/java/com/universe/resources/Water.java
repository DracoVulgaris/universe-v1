package com.universe.resources;

/**
 * An amount of drinkable Water that can be consumed by a life form that holds this resource
 *
 * @since 21/01/2017.
 */
public class Water extends Resource {

    @Override
    public String toString() {
        return "Water: " + quantity;
    }

    @Override
    public String getResourceName() {
        return "Water";
    }
}
