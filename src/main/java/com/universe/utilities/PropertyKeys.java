package com.universe.utilities;

/**
 * Enumeration to hold the values of the <code>universe.properties</code> keys
 *
 * @since 22/01/2017.
 */
public enum PropertyKeys {

    WIDTH("WIDTH"),
    HEIGHT("HEIGHT"),
    DEPTH("DEPTH");

    private final String key;

    PropertyKeys(String key) {
        this.key = key;
    }

    public String key() {
        return key;
    }

}
