package com.universe.elements;

/**
 * An amount of drinkable Water that can be consumed by a life form that holds this resource
 *
 * @since 21/01/2017.
 */
public class Water extends Resource {

    public Water(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Water: " + quantity;
    }

    @Override
    public String getResourceName() {
        return "Water";
    }
}
