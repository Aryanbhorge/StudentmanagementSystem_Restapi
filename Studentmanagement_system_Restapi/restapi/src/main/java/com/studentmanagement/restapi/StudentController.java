package com.studentmanagement.restapi;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private final Studentservice studentService;

    public StudentController(Studentservice studentService) {
        this.studentService = studentService;
    }

    // Display the list of students
    @GetMapping
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStd());
        return "listStudent"; // Thymeleaf template to display student list
    }

    // Show form to register a new student
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "registerStudent"; // Thymeleaf template to register a new student
    }

    // Save a new student
    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.addStd(student);
        return "redirect:/students";
    }

    // Show form to edit an existing student
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Student student = studentService.getStudentById(id);
        if (student != null) {
            model.addAttribute("student", student);
            return "registerStudent"; // Reuse form for editing
        } else {
            return "redirect:/students";
        }
    }

    // Update an existing student
    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable("id") Long id, @ModelAttribute("student") Student student) {
        Student existingStudent = studentService.getStudentById(id);
        if (existingStudent != null) {
            existingStudent.setStudentName(student.getStudentName());
            existingStudent.setStudentEmail(student.getStudentEmail());
            existingStudent.setCourse(student.getCourse());

            studentService.updateStudent(existingStudent);
        }
        return "redirect:/students";
    }

    // Delete a student
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStd(id);
        return "redirect:/students";
    }
}
