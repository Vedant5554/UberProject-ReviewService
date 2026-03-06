package com.example.uberreviewservice.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity //work on java logic layer
@Table(name = "BookingReview") //work on the database logic layer
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Review extends BaseModel{


    @Column(nullable = false) //this will not change once the column is created bcz  in properties we have given update
    private String content;

    private Double rating;



    @Override
    public String toString() {
        return "Review: " + this.content + " " + this.rating + " " + this.createdAt; }
}


//New Review(content,rating, createdAt,updatedAt)
