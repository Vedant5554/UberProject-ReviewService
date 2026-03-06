package com.example.uberreviewservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.UUID;


@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@Getter
@Setter
public abstract class BaseModel {
    @Id //this annotation makes the id property as a primary key of our table
    @GeneratedValue(generator = "UUID")
    protected UUID id ;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP) //This annotation tells spring about the formats of date object to be started i.e. Date /Time /Timestamp
    @CreatedDate  //this annotation tells spring that only handle it for object creation
    protected Date createdAt;


    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate  // this annotation tells spring that only handle it for object update
    protected Date updatedAt;
}
