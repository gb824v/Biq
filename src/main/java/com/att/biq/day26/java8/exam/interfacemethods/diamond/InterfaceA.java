package com.att.biq.day26.java8.exam.interfacemethods.diamond;

public interface InterfaceA {
    default int calc(int x1, int x2) {
        return x1 + x2;
    }
}
