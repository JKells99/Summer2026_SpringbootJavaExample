package com.keyin;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FakerTestTest {

    Faker faker;
    String fullName;
    String userName;
    String email;
    String jobTitle;

    @BeforeEach
    public void setUp() throws Exception {
        faker = new Faker();
        fullName = faker.name().fullName();
        userName = faker.name().username();
        email = faker.internet().emailAddress();
        jobTitle = faker.job().title();


    }

    @AfterEach
    public void tearDown() throws Exception {
        faker = null;
        fullName = null;
        userName = null;
        email = null;
        jobTitle = null;
    }


    @Test
    public void testFakeTest() {
        Assertions.assertNotNull(fullName);
        Assertions.assertNotNull(userName);
        Assertions.assertNotNull(email);
        Assertions.assertNotNull(jobTitle);

        String name = faker.name().fullName();





    }
}
//
//String fullName = faker.name().fullName();
//String username = faker.name().username();
//String email = faker.internet().emailAddress();
//String jobTitle = faker.job().title();
