package io.vnc.moviecatalog.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import io.vnc.moviecatalog.models.Rating;
import io.vnc.moviecatalog.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class UserRatingService {
    private static final String ratingUrl = "http://movie-rating-service/ratings/users/";

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getUserRatingFallback",
            threadPoolKey = "UserRatingPool",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "20"),
                    @HystrixProperty(name = "maxQueueSize", value = "10")
            })
    public UserRating getUserRating(@PathVariable("userId") String userId) {
        return restTemplate.getForObject(ratingUrl + userId, UserRating.class);
    }

    private UserRating getUserRatingFallback(@PathVariable("userId") String userId) {
        return new UserRating(userId, Arrays.asList(new Rating("-1", -1)));
    }
}
