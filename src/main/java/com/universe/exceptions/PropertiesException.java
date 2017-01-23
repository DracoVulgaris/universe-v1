package com.universe.exceptions;

/**
 * Exception thrown if there is a problem in the {@link com.universe.utilities.PropertiesManager}
 *
 * @since 23/01/2017.
 */
public class PropertiesException extends Exception
{



    public PropertiesException(String message) {
        super(message);
    }

    public PropertiesException(String message, Throwable e) {
        super(message, e);
    }
}
