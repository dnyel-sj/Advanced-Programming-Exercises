package com.kiau;

public class DetectionType implements MyInteger {
    private int number;

    public DetectionType() {
        System.out.println("object is created.");
    }
    public DetectionType(int a) {
        set(a);
    }
    public void set(int a) {
        number = a;
    }
    @Override
    public void isEven() {
        if(number % 2 == 0 && number != 0)
            System.out.println("the number is even.");
    }

    @Override
    public void isOdd() {
        if(number % 2 != 0)
            System.out.println("the number is odd.");
    }

    @Override
    public void isPositive() {
        if(number > 0)
            System.out.println("the number is positive.");
    }

    @Override
    public void isNegative() {
        if(number < 0)
            System.out.println("the number is negative.");
    }

    @Override
    public void isZero() {
        if(number == 0)
            System.out.println("the number is zero.");
    }
}
