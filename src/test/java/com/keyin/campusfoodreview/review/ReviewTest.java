package com.keyin.campusfoodreview.review;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReviewTest {

    Review review;

    @BeforeEach
    void setUp() {
        review = new Review("Awesome Pizza!", 1L);
    }
    @AfterEach
    void tearDown() {
        review = null;
    }

    //*
    // Test 1 - Review Creation
    // *
    @Test
    void testReviewCreation(){
        Assertions.assertEquals("Awesome Pizza!", review.getReviewText());
        Assertions.assertNotNull(review.getReviewDate());
        Assertions.assertEquals(1L, review.getUserId());
    }

    @Test
    void testReviewSetters(){
        review.setReviewText("Great pizza!");
        review.setUserId(2L);

        Assertions.assertEquals("Great pizza!", review.getReviewText());
        Assertions.assertEquals(2L, review.getUserId());
    }


}
