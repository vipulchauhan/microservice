package io.vnc.moviecatalog.resource;

import io.vnc.moviecatalog.models.CatalogItem;
import io.vnc.moviecatalog.models.UserRating;
import io.vnc.moviecatalog.services.MovieInfoService;
import io.vnc.moviecatalog.services.UserRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    private MovieInfoService movieInfoService;

    @Autowired
    private UserRatingService userRatingService;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
        UserRating userRating = userRatingService.getUserRating(userId);
        List<CatalogItem> list = userRating.getRatings()
                .stream()
                .map(rating -> movieInfoService.getCatalogItem(rating))
                .collect(Collectors.toList());
        return list;
    }


}


/* Movie m = webClientBuilder.build()
                    .get()
                    .uri(moviesUrl + rating.getMovieId())
                    .retrieve()
                    .bodyToMono(Movie.class)
                    .block();
               */