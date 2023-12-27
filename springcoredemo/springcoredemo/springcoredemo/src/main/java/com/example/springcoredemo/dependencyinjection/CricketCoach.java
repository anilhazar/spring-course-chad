package com.example.springcoredemo.dependencyinjection;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Do plank for 15 mins";
    }


}
