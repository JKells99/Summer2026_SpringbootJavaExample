package com.keyin.campusfoodreview.review;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keyin.campusfoodreview.restaurant.RestaurantRepository;
import com.keyin.campusfoodreview.review.dto.ReviewRequestDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ReviewController.class)
public class ReviewControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ReviewService reviewService;

    @MockitoBean
    private RestaurantRepository restaurantRepository;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        Mockito.reset(reviewService, restaurantRepository);
    }

    @Test
    void getAllReviews_returnsOkWithList() throws Exception {
        List<Review> reviews = List.of(
                new Review("Great food!"),
                new Review("Would eat again.")
        );

        Mockito.when(reviewService.getAllReviews()).thenReturn(reviews);

        mockMvc.perform(get("/api/review"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].reviewText").value("Great food!"));
    }

    @Test
    void createNewReview_returnsCreatedWithReview() throws Exception {
        ReviewRequestDto requestDto = new ReviewRequestDto("Loved it!", null);
        Review saved = new Review("Loved it!");

        Mockito.when(reviewService.saveReview(Mockito.any(Review.class))).thenReturn(saved);

        mockMvc.perform(post("/api/review")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.reviewText").value("Loved it!"));
    }
}
