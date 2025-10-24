package com.faculty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FacultyServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(FacultyServiceApplication.class, args);
        System.out.println("Faculty Service is running...");
    }
}
