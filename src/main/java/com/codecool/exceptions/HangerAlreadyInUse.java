package com.codecool.exceptions;

public class HangerAlreadyInUse extends RuntimeException {
    public HangerAlreadyInUse(String message) {
        super(message);
    }
}
