package dev.elitebytecode.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    //Talk to database alternatively with Template class
    @Autowired
    MongoTemplate mongoTemplate;

    public Review createReview(String reviewBody, String imdbId){
        Review review = new Review(reviewBody);

        reviewRepository.insert(review);

        // update review id
        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review));

        return review;

    }
}
