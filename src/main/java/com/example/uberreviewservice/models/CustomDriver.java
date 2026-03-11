package com.example.uberreviewservice.models;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
public class CustomDriver {

    private Long id;

    private String name;

    public CustomDriver(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
