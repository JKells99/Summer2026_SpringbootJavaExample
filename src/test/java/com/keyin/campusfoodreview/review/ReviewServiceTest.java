package com.keyin.campusfoodreview.review;

import com.keyin.campusfoodreview.restaurant.Restaurant;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ReviewServiceTest {
    @Mock
    private ReviewRepository reviewRepository;

    @InjectMocks
    private ReviewService reviewService;

    Review review;
    Review review2;
    Restaurant restaurant;
    List<Review> reviews;

    @BeforeEach
    void setUp() {
        review = new Review("Great food!");
        review2 = new Review("Would eat again.");
        reviews = List.of(review, review2);
        restaurant = new Restaurant("Restaurant 1", "Address 1", "111-1111");
        review.setRestaurant(restaurant);
        review2.setRestaurant(restaurant);

    }

    @AfterEach
    void tearDown() {
        review = null;
        review2 = null;
        reviews = null;
    }

    @Test
    public void fullListGetsReturned() {
        Mockito.when(reviewRepository.findAll()).thenReturn(reviews);

        List<Review> expected = reviewService.getAllReviews();

        Assertions.assertEquals(reviews, expected);
    }

    @Test
    public void getReviewByIdReturnsCorrectReview() {
        Mockito.when(reviewRepository.findById(1L)).thenReturn(Optional.of(review));

        Optional<Review> expected = reviewService.getReviewById(1L);

        Assertions.assertTrue(expected.isPresent());
        Assertions.assertEquals(review, expected.get());
    }

    @Test
    public void saveNewReviewReturnsSavedReview() {
        Mockito.when(reviewRepository.save(review)).thenReturn(review);

        Review expected = reviewService.saveReview(review);

        Assertions.assertEquals(review, expected);
    }
}
