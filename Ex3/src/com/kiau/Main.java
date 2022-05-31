package com.kiau;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("enter a integer number: ");
        int a = input.nextInt();
        DetectionType myNumber = new DetectionType(a);
        myNumber.isEven();
        myNumber.isOdd();
        myNumber.isPositive();
        myNumber.isNegative();
        myNumber.isZero();
    }
}
