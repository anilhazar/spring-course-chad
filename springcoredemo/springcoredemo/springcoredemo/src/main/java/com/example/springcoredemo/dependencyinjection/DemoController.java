package com.example.springcoredemo.dependencyinjection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private final Coach myCoach;

   public DemoController(Coach theCoach) {
        myCoach = theCoach;

    }
    /*
   @Autowired
   public void setMyCoach(Coach theCoach){
       myCoach=theCoach;
   }
*/
    @GetMapping("/dailyworkout")
    public String dailyWorkout() {
        return myCoach.getDailyWorkout();
    }

}
