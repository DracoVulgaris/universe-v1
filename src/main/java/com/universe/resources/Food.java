package com.universe.resources;

/**
 * An amount of edible Food that can be consumed by a life form that holds this resource
 *
 * @since 21/01/2017.
 */
public class Food extends Resource {

    @Override
    public String toString() {
        return "Food: " + quantity;
    }

    @Override
    public String getResourceName() {
        return "Food";
    }
}
