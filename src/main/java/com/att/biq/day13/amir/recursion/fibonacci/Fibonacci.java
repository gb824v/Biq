package com.att.biq.day13.amir.recursion.fibonacci;

public class Fibonacci {

    public static void main(String[] args) {
        for(int i=0; i<=20; ++i) {
            System.out.println("fib(" + i + ") = " + fibonacci(i) + " = " + fibonacciAsLoop(i));
        }
    }

    private static int fibonacciAsLoop(int index) {
        int fib_minus_1 = 1;
        int fib = 0;
        for(int i=0; i<index; ++i) {
            int old_fib = fib;
            fib += fib_minus_1;
            fib_minus_1 = old_fib;
        }
        return fib;
    }

    public static int fibonacci(int i) {
        return fibonacci2(i)[1];
    }

    // returns fibonacci(i) in index 1
    //    and  fibonacci(i-1) in index 0
    private static int[] fibonacci2(int i) {
        if(i == 1) {
            return new int[]{0, 1};
        }
        else if(i == 0) {
            return new int[]{1, 0};
        }
        int[] arr = fibonacci2(i-1);
        return new int[]{arr[1], arr[0] + arr[1]};
    }
}
