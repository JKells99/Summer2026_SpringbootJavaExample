package com.keyin;

import com.github.javafaker.Faker;

import java.util.Scanner;

public class FakeTest {
    static void main() {
        Faker faker = new Faker();
        Scanner sc = new Scanner(System.in);
        System.out.println("How many fake names do you want to generate?");
        int numberOfNames = sc.nextInt();
        for (int i = 0; i < numberOfNames; i++) {
            String fakeName = faker.name().fullName();
            System.out.println(fakeName);
        }
    }
}
