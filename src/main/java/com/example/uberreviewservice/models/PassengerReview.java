package com.example.uberreviewservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class PassengerReview extends Review{

    @Column(nullable = false) // we can do this now bcz we are using joined table now
    private String passengerReviewContent;

    private String passengerRating;
}
