package com.keyin.campusfoodreview.review;

import com.keyin.campusfoodreview.restaurant.Restaurant;
import com.keyin.campusfoodreview.restaurant.RestaurantRepository;
import com.keyin.campusfoodreview.review.dto.ReviewRequestDto;
import com.keyin.campusfoodreview.review.dto.ReviewResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/review")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @Autowired
    RestaurantRepository restaurantRepository;

    @PostMapping
    public ResponseEntity<ReviewResponseDto> createNewReview(@RequestBody ReviewRequestDto reviewRequestDto) {
        Restaurant restaurant = null;
        if (reviewRequestDto.restaurantId() != null) {
            restaurant = restaurantRepository.findById(reviewRequestDto.restaurantId()).orElse(null);
        }

        Review review = new Review(reviewRequestDto.reviewText(), restaurant);
        Review saved = reviewService.saveReview(review);
        return ResponseEntity.status(HttpStatus.CREATED).body(ReviewResponseDto.from(saved));
    }

    @GetMapping
    public ResponseEntity<List<ReviewResponseDto>> getAllReviews() {
        List<ReviewResponseDto> reviews = reviewService.getAllReviews().stream()
                .map(ReviewResponseDto::from)
                .toList();
        return ResponseEntity.ok(reviews);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewResponseDto> getReviewById(@PathVariable Long id) {
        Optional<Review> review = reviewService.getReviewById(id);
        return review.map(value -> ResponseEntity.ok(ReviewResponseDto.from(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReview(@PathVariable Long id) {
        reviewService.deleteReviewById(id);
        return ResponseEntity.ok("Review with id " + id + " has been deleted");
    }
}
