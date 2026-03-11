package com.example.uberreviewservice.service;

import com.example.uberreviewservice.models.Booking;
import com.example.uberreviewservice.models.Driver;
import com.example.uberreviewservice.repositories.BookingRepository;
import com.example.uberreviewservice.repositories.DriverRepository;
import com.example.uberreviewservice.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.*;

@Service
public class ReviewService implements CommandLineRunner {

    private ReviewRepository reviewRepository;

    private BookingRepository bookingRepository;

    private DriverRepository driverRepository;


    public ReviewService(ReviewRepository reviewRepository, BookingRepository bookingRepository, DriverRepository driverRepository) {
        this.reviewRepository = reviewRepository;
        this.bookingRepository = bookingRepository;
        this.driverRepository = driverRepository;
    }
    @Override
    @Transactional
    public void run(String... args) throws Exception {
        System.out.println("****************");

//        Review r= Review.builder()
//                .content("Amazing ride quality")
//                .rating(4.0)
//                .build(); //this code creates plain java object code
//
//
//        Booking b = Booking
//                .builder()
//                .review(r)
//                .endTime(new Date())
//                .build();
//
//        // reviewRepository.save(r); //This code execute sql query
//
//        bookingRepository.save(b);
//
//        System.out.println(r);
//
//        System.out.println(r.getId() );
//
//        List<Review> reviews = reviewRepository.findAll();
//
//        for(Review review : reviews){
//            System.out.println(r.getContent());
//        }
//        Optional<Booking> b = bookingRepository.findById(6L);
//        if(b.isPresent()){
//            bookingRepository.delete(b.get());
//        }

//        List<Driver> drivers = driverRepository.findAll();

//        Optional<Driver> driver = driverRepository.findById(1L);
//        if(driver.isPresent()){
//            System.out.println(driver.get().getName());
//            List<Booking> b = driver.get().getBooking();
////            List<Booking> bookings = bookingRepository.findAllByDriverId(1L);
//            for(Booking booking : b){
//                System.out.println(booking.getId());
//            }
////        Optional<Booking> b = bookingRepository.findById(1L);
//        }
        // reviewRepository.deleteById(2L);
        List<Long> driver_id = new ArrayList<>(Arrays.asList(1L,2L,3L,4L,5L));
        List<Driver> drivers = driverRepository.findAllByIdIn(driver_id);
//        List<Booking> bookings = bookingRepository.findAllByDriverIn((drivers)); //this is the first solution for the N+1 solution
        for(Driver driver:drivers){

            List <Booking> bookings = driver.getBooking(); // This for loop will end up having N+1 problem it will unnecessarly creates join for every column while going through loop every time
            bookings.forEach(booking -> System.out.println(booking.getId())); // this is 2nd one for these we need to makeehre fetchtype is lazy add annotation in which fetchmode is subselect @Fetch(fetchMode.subselect) but before this add this current class as @Transactional
        }

    }
}
