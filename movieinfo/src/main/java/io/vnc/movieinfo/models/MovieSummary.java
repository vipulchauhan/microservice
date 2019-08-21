package io.vnc.movieinfo.models;

public class MovieSummary {
    private int id;
    private String original_title;
    private String overview;
    private Double popularity;

    public MovieSummary() {
    }

    public MovieSummary(int id, String original_title, String overview, Double popularity) {
        this.id = id;
        this.original_title = original_title;
        this.overview = overview;
        this.popularity = popularity;
    }

    public int getMovieId() {
        return id;
    }

    public void setMovieId(int id) {
        this.id = id;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    @Override
    public String toString() {
        return "MovieSummary{" +
                "id=" + id +
                ", original_title='" + original_title + '\'' +
                ", overview='" + overview + '\'' +
                ", popularity=" + popularity +
                '}';
    }

    public Movie getMovie() {

        return new Movie("" + this.id, this.original_title, this.overview);
    }
}
