package dev.nisa.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        // Step 1: Spring converts JSON to a Review object (IN MEMORY ONLY)
        // review object exists but ISN'T in the database yet

        // Step 2: Call service to save to database
        Review savedReview = reviewService.createReview(
                review.getImdbId(),
                review.getBody()
        );
        // Now the review is saved in MongoDB and linked to the movie

        return new ResponseEntity<>(savedReview, HttpStatus.CREATED);
    }
}
