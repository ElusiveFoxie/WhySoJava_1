package com.example;

import java.io.ObjectInputFilter;

public class CustomClassFilter implements ObjectInputFilter{

    public Status checkInput(FilterInfo filterInfo) {
        Class<?> clazz = filterInfo.serialClass();
        if (clazz != null) {
            return !(clazz.getName().equals("com.example.User")) ? Status.ALLOWED : Status.REJECTED; //clazz.getPackage().equals("com.example")
        }
        return Status.UNDECIDED;
    }

}