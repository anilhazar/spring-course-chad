package com.springchadprojects.springrestdemo.rest;

import com.springchadprojects.springrestdemo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    List<Student> students;


    @PostConstruct
    public void loadStudents() {
        students = new ArrayList<>();
        students.add( new Student( "Anıl", "Hazar" ) );
        students.add( new Student( "Agit", "Rubar" ) );
        students.add( new Student( "İbrahim", "Deniz" ) );
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/students/{studentIndex}")
    public Student getStudent(@PathVariable int studentIndex) {
        if (studentIndex >= students.size() || studentIndex < 0) {
            throw new StudentNotFoundException( "Student id not found: " + studentIndex );
        }
        return students.get( studentIndex );
    }
}
