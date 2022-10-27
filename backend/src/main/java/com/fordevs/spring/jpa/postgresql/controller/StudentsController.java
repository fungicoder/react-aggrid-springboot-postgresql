package com.fordevs.spring.jpa.postgresql.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.fordevs.spring.jpa.postgresql.model.Department;
import com.fordevs.spring.jpa.postgresql.model.Student;
import com.fordevs.spring.jpa.postgresql.repository.DepartmentRepository;
import com.fordevs.spring.jpa.postgresql.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class StudentsController {

    @Autowired
    private StudentRepository studentRepository;



    //	getting all users
    @GetMapping("/users")
    public ResponseEntity<List<Student>> getAllUsers(@RequestParam(required = false) String fullName) {
        try {
            List<Student> students = new ArrayList<Student>();

            if (fullName == null)
                students.addAll(studentRepository.findAll());

            else
            students.addAll(studentRepository.findByFullNameContaining(fullName));

            if (students.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(students, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //	getting users by id
    @GetMapping("/users/{id}")
    public ResponseEntity<Student> getUsersById(@PathVariable("id") long id) {
        Optional<Student> userData = studentRepository.findById(id);

        return userData.map(student -> new ResponseEntity<>(student, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //	Create Student
    @PostMapping("/users")
    public ResponseEntity<Student> createUser(@RequestBody Student student) {
        try {
            Student _student = studentRepository
                    .save(student);
            return new ResponseEntity<>(_student, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //	Update Student
    @PutMapping("/users/{id}")
    public ResponseEntity<Student> updateUser(@PathVariable("id") long id, @RequestBody Student student) {
        Optional<Student> userData = studentRepository.findById(id);

        if (userData.isPresent()) {
            Student _student = userData.get();
            _student.setFullName(student.getFullName());
            _student.setEmail(student.getEmail());
            _student.setPhone(student.getPhone());
            _student.setDob(student.getDob());
            return new ResponseEntity<>(studentRepository.save(_student), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete Student
    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") long id) {
        try {
            studentRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete All Student
    @DeleteMapping("/users")
    public ResponseEntity<HttpStatus> deleteAllUsers() {
        try {
            studentRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
