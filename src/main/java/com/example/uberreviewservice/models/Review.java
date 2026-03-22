package com.example.uberreviewservice.models;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity //work on java logic layer
@Table(name = "BookingReview") //work on the database logic layer
@Inheritance(strategy = InheritanceType.JOINED)
public class Review extends BaseModel{

    @Column(nullable = false) //this will not change once the column is created bcz  in properties we have given update
    private String content;

    private Double rating;

    @OneToOne(cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Booking booking; //we have one to one relation with review and booking



    @Override
    public String toString() {
        return "Review: " + this.content + " " + this.rating + " " + this.createdAt; }
}


//New Review(content,rating, createdAt,updatedAt)
