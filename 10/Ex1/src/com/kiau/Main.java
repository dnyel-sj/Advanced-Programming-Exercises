package com.kiau;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        User user = new User();
        Thread thread1 = new Thread()
        {
            @Override
            public void run() {
                System.out.print("enter the name: ");
                String name = input.nextLine();
                System.out.print("enter the username: ");
                String username = input.nextLine();
                System.out.print("enter the password: ");
                String password = input.nextLine();
                System.out.print("enter the email: ");
                String email = input.nextLine();
                user.setName(name).setUsername(username).setPassword(password).setEmail(email);
                try {
                    user.connection();
                    user.insert();
                    user.commit();
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                try {
                    user.connection();
                    user.select();
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        };
        FileOperation fileOperation = new FileOperation();
        thread1.start();
        thread2.start();
        fileOperation.start();
    }
}
