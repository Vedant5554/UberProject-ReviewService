package com.example.uberreviewservice.service;

import com.example.uberreviewservice.models.Booking;
import com.example.uberreviewservice.models.Driver;
import com.example.uberreviewservice.models.Review;
import com.example.uberreviewservice.repositories.BookingRepository;
import com.example.uberreviewservice.repositories.DriverRepository;
import com.example.uberreviewservice.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.*;

@Service
public interface ReviewService {

    public Optional<Review> findReviewById(Long id);

    public List<Review> findAllReviews();

    public boolean deleteReviewById(Long id);

    public Review publishReview(Review review);

    public Review updateReview(Long id, Review review);

}