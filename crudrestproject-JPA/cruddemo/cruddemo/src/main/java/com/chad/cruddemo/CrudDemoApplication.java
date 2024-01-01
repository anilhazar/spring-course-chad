package com.chad.cruddemo;

import com.chad.cruddemo.dao.StudentRepository;
import com.chad.cruddemo.entity.Student;
import com.chad.cruddemo.dao.StudentDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.boot.SpringApplication.*;
@Service
@SpringBootApplication
public class CrudDemoApplication {

    public static void main(String[] args) {
        run( CrudDemoApplication.class, args );
    }
@Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO, StudentRepository studentRepository) {
        return runner -> {

            createStudent(studentDAO);
            //readStudent(studentDAO);
            //readAllStudents(studentDAO);
            //readByIdRepository(studentRepository);
            //findStudentsByLastname(studentDAO);
            //updateAStudent( studentDAO );
            //updateStudentsByLastName( studentDAO );
            //deleteAStudent( studentDAO );
            deleteAllStudents( studentDAO );
        };
    }

    public void createStudent(StudentDAO studentDAO) {
        Student tempStudent1 = new Student( "Agit Rubar", "Demir", "agit.rubar@gmail.com" );
        Student tempStudent2 = new Student( "Anil", "Hazar", "alianilhazar@gmail.com" );
        Student tempStudent3 = new Student("Ahmet", "Kanadli", "kanadli.ahmet@gmail.com");
        studentDAO.save( tempStudent1 );
        studentDAO.save( tempStudent2 );
        studentDAO.save( tempStudent3 );

        readAllStudents( studentDAO );

    }

    public void readStudent(StudentDAO studentDAO) {

        //System.out.println(studentDAO.findById(5));
        System.out.println( studentDAO.findById( 5L ) );
    }

    public void findStudentsByLastname(StudentDAO studentDAO) {
        List<Student> allStudents = studentDAO.findByLastname( "Selam" );

        for (Student student : allStudents) {
            System.out.println( student );

        }


    }

    public void updateAStudent(StudentDAO studentDAO) {
        int studentId = 4;
        Student student = studentDAO.findById( 5L );

        student.setFirstName( "Anil" );

        studentDAO.update( student );

        System.out.println( student );
    }

    public void findStudentByLastname(StudentDAO studentDAO) {
        List<Student> students = studentDAO.findByLastname( "Demir" );
        for (Student student : students) {
            System.out.println( student );
        }
    }

    public void updateStudentsByLastName(StudentDAO studentDAO) {
        studentDAO.updateAllStudents( "Tester" );

        readAllStudents( studentDAO );
    }


	/*public void readByIdRepository(StudentRepository studentRepository){
		System.out.println(studentRepository.findById(5L));
	}
    */

    public void readAllStudents(StudentDAO studentDAO) {
        List<Student> students = studentDAO.findAll();
        for (Student student : students) {
            System.out.println( student );
        }
    }

    public void deleteAStudent(StudentDAO studentDAO) {
        Long studentId = 10L;

        Student toBeDeletedStudent = studentDAO.findById( studentId );

        studentDAO.delete( toBeDeletedStudent, studentId );

        readAllStudents( studentDAO );
    }

    public void deleteAllStudents(StudentDAO studentDAO){
        System.out.println("Number of Students Deleted : " + studentDAO.deleteAllStudents());

        readAllStudents( studentDAO );
    }
}
