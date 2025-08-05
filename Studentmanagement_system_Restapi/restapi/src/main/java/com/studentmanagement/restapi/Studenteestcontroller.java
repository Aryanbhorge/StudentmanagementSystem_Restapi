package com.studentmanagement.restapi;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "http://localhost:5500")
public class Studenteestcontroller {

    @Autowired
    private final Studentservice studentservice;

    public Studenteestcontroller(Studentservice studentservice) {
        this.studentservice = studentservice;
    }

    @GetMapping
    public List<Student> listStudents() {
        return studentservice.getAllStd();
    }

    @PostMapping("/register")
    public Student saveStudent(@RequestBody Student student) {
        studentservice.addStd(student);
        return student;
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable("id") Long id) {
        Student student = studentservice.getStudentById(id);
        if (student != null) return student;
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student Not Found");
    }

    @PutMapping("/update/{id}")
    public Student updateStudent(@PathVariable("id") Long id, @RequestBody Student stud) {
        Student existing = studentservice.getStudentById(id);
        if (existing != null) {
            existing.setStudentName(stud.getStudentName());
            existing.setStudentEmail(stud.getStudentEmail());
            existing.setCourse(stud.getCourse());
            studentservice.updateStudent(existing);
            return existing;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student Not Found");
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        studentservice.deleteStd(id);
        return id + " Student Deleted Successfully";
    }
}
