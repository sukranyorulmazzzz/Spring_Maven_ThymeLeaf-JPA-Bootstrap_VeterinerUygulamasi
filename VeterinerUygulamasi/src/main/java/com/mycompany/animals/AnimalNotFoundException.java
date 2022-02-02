package com.mycompany.animals;

public class AnimalNotFoundException extends Throwable {
    public AnimalNotFoundException(String message) {
        super(message);
    }
}
