package com.example.uberreviewservice.service;

import com.example.uberreviewservice.models.Review;
import com.example.uberreviewservice.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReviewService implements CommandLineRunner {

    private ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("****************");
        Review r= Review.builder()
                .content("Amazing ride quality")
                .rating(4.0)
                .build(); //this code creates plain java object code

        System.out.println(r);
        reviewRepository.save(r); //This code execute sql query
        System.out.println(r.getId() );

        List<Review> reviews = reviewRepository.findAll();

        for(Review review : reviews){
            System.out.println(r.getContent());
        }


        // reviewRepository.deleteById(2L);
    }
}
