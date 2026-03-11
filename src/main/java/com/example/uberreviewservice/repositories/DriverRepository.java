package com.example.uberreviewservice.repositories;

import com.example.uberreviewservice.models.Booking;
import com.example.uberreviewservice.models.CustomDriver;
import com.example.uberreviewservice.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver, Long> {

    Optional<Driver> findByIdAndLicenseNumber(Long id , String LicenseNumber);


    @Query(nativeQuery = true , value = "SELECT * FROM driver WHERE id = :id AND license_number =:license") //this is raw mysql query ,error is throen at runtime in query
    Optional<Driver> rawfingByIdAndLicenseNumber(Long id, String license);

//    @Query("SELECT d FROM Driver d WHERE d.id = :id AND d.licenseNumber = :ln")
//    Optional<Driver> hqlfindByIdAndLicense(Long id , String ln);

    @Query("SELECT d FROM Driver d WHERE d.id = :id AND d.licenseNumber = :ln")
    Optional<CustomDriver> hqlfindByIdAndLicense(Long id , String ln);


}
