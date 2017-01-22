package com.universe.exceptions;

/**
 * Exception thrown if there is a problem in the {@link com.universe.environment.Universe}
 *
 * @since 21/01/2017.
 */
public class UniverseException extends Exception {


    public UniverseException(String message) {
        super(message);
    }

    public UniverseException(String message, Throwable e) {
        super(message, e);
    }
}
