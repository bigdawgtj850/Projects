package com.sg.vendingmachine.service;

/**
 *
 * @author ShantelJ
 */
public class OutOfCoinsException extends Exception {

    public OutOfCoinsException(String message) {
        super(message);
    }

    public OutOfCoinsException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
