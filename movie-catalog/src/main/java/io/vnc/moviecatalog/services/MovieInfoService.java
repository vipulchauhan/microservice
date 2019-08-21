package io.vnc.moviecatalog.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import io.vnc.moviecatalog.models.CatalogItem;
import io.vnc.moviecatalog.models.Movie;
import io.vnc.moviecatalog.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieInfoService {
    private static final String moviesUrl = "http://movie-info-service/movies/";

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getCatalogItemFallback",
            //separate bucket
            threadPoolKey = "catalogItemPool",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "20"),
                    @HystrixProperty(name = "maxQueueSize", value = "10")
            },
            commandProperties = {
                    // time out
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
                    // no of request to consider for fallback
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
                    // no of times fails in percentage before trip
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
                    //time to untrip after triping
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")
            })
    public CatalogItem getCatalogItem(Rating rating) {
        Movie m = restTemplate.getForObject(moviesUrl + rating.getMovieId(), Movie.class);
        return new CatalogItem(m.getName(), m.getDescription(), rating.getRating());
    }

    private CatalogItem getCatalogItemFallback(Rating rating) {
        return new CatalogItem("Movie not found", "No description", rating.getRating());
    }


}
