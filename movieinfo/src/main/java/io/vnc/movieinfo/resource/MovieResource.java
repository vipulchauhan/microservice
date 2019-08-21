package io.vnc.movieinfo.resource;

import io.vnc.movieinfo.models.Movie;
import io.vnc.movieinfo.models.MovieSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieResource {

    private static final String MOVIE_API_URL = "https://api.themoviedb.org/3/movie/";
    @Autowired
    private RestTemplate restTemplate;
    @Value("${api.key}")
    private String api_key;

    private List<Movie> movies = Arrays.asList(
            new Movie("20191", "Bharat", "test"),
            new Movie("20192", "Bahubali", "test"),
            new Movie("20193", "Dilwale", "test"),
            new Movie("20194", "Kahani", "test"),
            new Movie("20195", "Sanju", "test")
    );

   /* @RequestMapping("{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
        Optional<Movie> first = movies.stream().filter(e -> e.getMovieId().equalsIgnoreCase(movieId)).findFirst();
        return first.get();
    }*/

    @RequestMapping("{movieId}")
    public Movie getMovie(@PathVariable("movieId") String movieId) {
        String finalUrl = MOVIE_API_URL + movieId + "?api_key=" + api_key;
        MovieSummary ms = this.restTemplate.getForObject(finalUrl, MovieSummary.class);
        ms.setMovieId(Integer.parseInt(movieId));
        return ms.getMovie();
    }

}
