package com.universe.exceptions;

/**
 * Exception thrown if there is a problem in the {@link com.universe.environment.Location}
 *
 * @since 21/01/2017.
 */
public class LocationException extends Exception {

    public LocationException(String message) {
        super(message);
    }
}
