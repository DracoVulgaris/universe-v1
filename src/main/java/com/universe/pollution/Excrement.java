package com.universe.pollution;

/**
 * @since 28/01/2017.
 */
public class Excrement extends Pollution {


    @Override
    public String getPollutionName() {
        return "Excrement";
    }

    @Override
    public String toString() {
        return "Excrement: " + quantity;
    }
}
