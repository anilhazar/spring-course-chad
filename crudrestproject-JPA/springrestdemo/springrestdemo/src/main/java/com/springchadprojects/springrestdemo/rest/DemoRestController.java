package com.springchadprojects.springrestdemo.rest;

import com.springchadprojects.springrestdemo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
public class DemoRestController {

    @GetMapping("/helloworld")
    public String sayHello(){
        return "Hello World";
    }



}
