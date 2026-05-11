package com.keyin;

import com.github.javafaker.Faker;

import java.util.Scanner;

public class FakeTest {
    public static void main(String[] args) {
        Faker faker = new Faker();

        try (Scanner sc = new Scanner(System.in)) {
            int numberOfNames = readCount(sc, "How many fake names do you want to generate?");
            for (int i = 0; i < numberOfNames; i++) {
                System.out.println(faker.name().fullName());
            }

            int numberOfQuotes = readCount(sc, "How many back to the future quotes do you want to generate?");
            for (int i = 0; i < numberOfQuotes; i++) {
                System.out.println(faker.backToTheFuture().quote());
            }

            int numberOfAddresses = readCount(sc, "How many fake addresses do you want to generate?");
            for (int i = 0; i < numberOfAddresses; i++) {
                System.out.println(faker.address().fullAddress());
            }

            int numberOfCompanyNames = readCount(sc, "How many fake company names do you want to generate?");
            for (int i = 0; i < numberOfCompanyNames; i++) {
                System.out.println(faker.company().name());
            }

            int numberOfProfiles = readCount(sc, "How many fake user profiles do you want to generate for signup testing?");
            for (int i = 0; i < numberOfProfiles; i++) {
                printFakeProfile(faker, i + 1);
            }
        }
    }

    private static int readCount(Scanner sc, String prompt) {
        while (true) {
            System.out.println(prompt);
            String input = sc.nextLine().trim();

            try {
                int count = Integer.parseInt(input);
                if (count < 0) {
                    System.out.println("Please enter 0 or a positive number.");
                    continue;
                }
                return count;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a whole number.");
            }
        }
    }

    public static void printFakeProfile(Faker faker, int profileNumber) {
        String fullName = faker.name().fullName();
        String username = faker.name().username();
        String email = faker.internet().emailAddress();
        String jobTitle = faker.job().title();

        System.out.printf("Profile %d:%n", profileNumber);
        System.out.printf("  Name: %s%n", fullName);
        System.out.printf("  Username: %s%n", username);
        System.out.printf("  Email: %s%n", email);
        System.out.printf("  Job Title: %s%n", jobTitle);
    }
}
