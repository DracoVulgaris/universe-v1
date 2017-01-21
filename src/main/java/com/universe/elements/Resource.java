package com.universe.elements;

/**
 * Consumable resource that is required by all lifeforms in varying degrees.
 *
 * @since 21/01/2017.
 */
 public abstract class Resource {

    Integer quantity;


    /**
     * Returns a specified amount of this resource if there is enough left otherwise it returns whats left.
     *
     * @param amount the amount of the resource requested
     * @return the amount of resource that can be returned
     */
    Integer consume(Integer amount) {
        Integer suppliedAmount;
        if (amount > quantity) {
            suppliedAmount = quantity;
            quantity = 0;
        } else {
            suppliedAmount = amount;
            quantity = quantity - amount;
        }
        return suppliedAmount;
    }

    public abstract String getResourceName();

}
