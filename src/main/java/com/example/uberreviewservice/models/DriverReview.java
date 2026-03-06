package com.example.uberreviewservice.models;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class DriverReview extends Review{
    private String driverReviewComment;
}
