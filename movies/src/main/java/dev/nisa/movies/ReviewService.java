package dev.nisa.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;  // Add this

@Service  // Add this annotation
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Review createReview(String imdbId, String body) {
        // Step 3: Create and save review in MongoDB
        // This creates a new document in the 'reviews' collection:
        // {
        //    "_id": <generated MongoDB ObjectId>,
        //    "imdbId": "tt10298840",
        //    "body": "This movie was amazing!"
        // }
        Review review = new Review(imdbId, body);
        Review savedReview= reviewRepository.insert(review);

        // Step 4: Update the movie document to include reference to this review
        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                // Find movie: db.movies.findOne({"imdbId": "tt10298840"})

                .apply(new Update().push("reviewIds").value(savedReview.getId()))
                // Because of @DocumentReference, only the ObjectId is stored!
                // db.movies.updateOne(
                //    {"imdbId": "tt10298840"},
                //    {$push: {"reviewIds": ObjectId("...")}  // Just the ID, not the whole review
                // )

                .first();

        return review;
    }
}