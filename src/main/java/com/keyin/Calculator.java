package com.keyin;

public class Calculator {

    // Method for adding two numbers
    public int add(int a, int b) {
        return a + b;
    }

    //Method for dividing two numbers
    public int divide(int a, int b) {
        if(a <=0 || b <=0){
            throw new IllegalArgumentException("Numbers must be positive to multiply");
        }
        return a / b;
    }

    // Method For multiplying two numbers
    public int multiply(int a, int b) {
        return a * b;
    }
}
