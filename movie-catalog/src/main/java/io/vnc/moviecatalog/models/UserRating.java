package io.vnc.moviecatalog.models;

import java.util.List;

public class UserRating {

    private List<Rating> ratings;
    private String userId;

    public UserRating() {
    }

    public UserRating(String userId, List<Rating> ratings) {
        this.ratings = ratings;
        this.userId = userId;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
