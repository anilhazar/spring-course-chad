package com.example.coolapp.CoolApp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class FunRestController {
@GetMapping("/")
public String sayHello(){
    return "Hello World!";
}
@GetMapping("/workout")
    public String dailyWorkout(){
    return "Run for 5km!";
}
@Value("${coach.name}")
private String coachName;
@Value("${team.name}")
private String teamName;

@GetMapping("/mouse")
    public String getMouseFamily() {
    return "Coach Name: "+ coachName + " and Team Name: "+ teamName;
 }
}

