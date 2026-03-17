package com.example.uberreviewservice.models;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Booking extends BaseModel{

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Review review; //we have one to one relation with review and booking

    @Enumerated(value = EnumType.STRING)
    private BookingStatus bookingStatus;

    @Column(name = "start_time")
    private LocalDateTime startTime;


    @Column(name = "end_time")
    private LocalDateTime endTime;

    private Long totalDistance;

    @ManyToOne
    private Driver driver;

    @ManyToOne
    private Passenger passenger;

}
