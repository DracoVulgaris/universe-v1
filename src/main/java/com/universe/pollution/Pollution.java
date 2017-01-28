package com.universe.pollution;

/**
 * Excreted pollution that is produced by all lifeforms in varying degrees.
 *
 * @since 28/01/2017.
 */
 public abstract class Pollution {

    Integer quantity = 0;


    /**
     * Returns a specified amount of this resource if there is enough left otherwise it returns whats left.
     *
     * @param amount the amount of pollution produced
     */
    public void produce(Integer amount) {
        quantity += amount;
    }

    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Get the name of this Pollution
     * @return the name of the Pollution
     */
    public abstract String getPollutionName();

}
