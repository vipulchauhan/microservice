package io.vnc.ratingdata.resource;

import io.vnc.ratingdata.models.Rating;
import io.vnc.ratingdata.models.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingDataService {

    private List<Rating> ratingList = Arrays.asList(
            new Rating("505", 4),
            new Rating("506", 3),
            new Rating("507", 5),
            new Rating("508", 3)
    );

    @RequestMapping("{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId) {
        return new Rating(movieId, 4);
    }

    @RequestMapping("users/{userId}")
    public UserRating getUserRatings(@PathVariable("userId") String userId) {
        List<Rating> ratings = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            ratings.add(new Rating("" + (500 + i), (int) (Math.random() * 10)));
        }
        return new UserRating(userId, ratings);
    }

}
