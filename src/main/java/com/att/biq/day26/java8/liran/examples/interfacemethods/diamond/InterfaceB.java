package com.att.biq.day26.java8.liran.examples.interfacemethods.diamond;

public interface InterfaceB {
    default int calc (int x1, int x2){
        return x1-x2;
    }
}
