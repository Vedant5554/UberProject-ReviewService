package com.example.uberreviewservice.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.TenantId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity //work on java logic layer
@Table(name = "BookingReview") //work on the database logic layer

public class Review {
    @Id //this annotation makes the id property as a primary key of our table
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    @Column(nullable = false) //this will not change once the column is created bcz  in properties we have given update
    private String content;

    private Double rating;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP) //This annotation tells spring about the formats of date object to be started i.e. Date /Time /Timestamp
    @CreatedDate  //this annotation tells spring that only handle it for object creation
    private Date createdAt;


    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate  // this annotation tells spring that only handle it for object update
    private Date updatedAt;

    @Override
    public String toString() {
        return "Review: " + this.content + " " + this.rating + " " + this.createdAt;
    }
}


//New Review(content,rating, createdAt,updatedAt)
