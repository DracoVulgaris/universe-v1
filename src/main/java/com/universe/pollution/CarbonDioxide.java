package com.universe.pollution;

/**
 * An amount of Carbon Dioxide that is produced by lifeforms
 *
 * @since 28/01/2017.
 */
public class CarbonDioxide extends Pollution {

    @Override
    public String getPollutionName() {
        return "Carbon Dioxide";
    }

    @Override
    public String toString() {
        return "Carbon Dioxide: " + quantity;
    }
}
