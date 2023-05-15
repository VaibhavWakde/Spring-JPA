package com.dailycodebuffer.spring.data.jpa.tutorial.repository;

import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Guardian;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("abc@gmail.com")
                .firstName("Abc")
                .lastName("Def")
//                .guardianName("Nikhil")
//                .guardianEmail("nikhil@gmail.com")
//                .guardianMobile("9999999999")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {

        Guardian guardian = Guardian.builder()
                .email("vivek@gmail.com")
                .name("vivek")
                .mobile("9999999999")
                .build();

        Student student = Student.builder()
                .firstName("Vaibhav")
                .emailId("vaibhav@gmail.com")
                .lastName("Wakde")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void  printAllStudent() {
        List<Student> studentList =
                studentRepository.findAll();

        System.out.println("studentList = "+ studentList);

    }

    @Test
    public void printStudentByFirstName() {
        List<Student> students = studentRepository.findByFirstName("shivam");

        System.out.println("students = "+ students);
    }

    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> students = studentRepository.findByFirstNameContaining("sh");

        System.out.println("students = "+ students);
    }

    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> students =
                studentRepository.findByGuardianName("Nikhil");

        System.out.println("students = "+students);
    }

    @Test
    public void printgetStudentByEmailAddress() {
        Student student =
                studentRepository.getStudentByEmailAddress("vaibhav@gmail.com");

        System.out.println("student = "+student);
    }


    @Test
    public void printgetStudentFirstNameByEmailAddress() {
        String firstName =
                studentRepository.getStudentFirstNameByEmailAddress("vaibhav@gmail.com");

        System.out.println("student = "+firstName);
    }

    @Test
    public void printgetStudentByEmailAddressNative(){
        Student student =
                studentRepository.getStudentByEmailAddressNative("vaibhav@gmail.com");

        System.out.println("student = "+student);
    }


    @Test
    public void printgetStudentByEmailAddressNativeNamedParam(){
        Student student =
                studentRepository.getStudentByEmailAddressNativeNamedParam("vaibhav@gmail.com");

        System.out.println("student = "+student);
    }

    @Test
    public void updateStudentNameByEmailIdTest() {
        studentRepository.updateStudentNameByEmailId(
                "Shabbir dawoodi",
                "shabbit@gmail.com"
        );
    }

}