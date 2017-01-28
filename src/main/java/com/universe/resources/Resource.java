package com.universe.resources;

/**
 * Consumable resource that is required by all lifeforms in varying degrees.
 *
 * @since 21/01/2017.
 */
 public abstract class Resource {

    Integer quantity = 0;


    /**
     * Returns a specified amount of this resource if there is enough left otherwise it returns whats left.
     *
     * @param amount the amount of the resource requested
     * @return the amount of resource that can be returned
     */
    public Integer consume(Integer amount) {
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

    public void setQuantity(Integer amount) {
        this.quantity = amount;
    }

    /**
     * Get the name of this Resource
     * @return the name of the Resource
     */
    public abstract String getResourceName();

}
