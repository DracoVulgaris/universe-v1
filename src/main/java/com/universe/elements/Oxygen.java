package com.universe.elements;

/**
 * An amount of breathable Oxygen that can be consumed by a life form that holds this resource
 *
 * @since 21/01/2017.
 */
public class Oxygen extends Resource {

    @Override
    public String toString() {
        return "Oxygen: " + quantity;
    }

    @Override
    public String getResourceName() {
        return "Oxygen";
    }
}
