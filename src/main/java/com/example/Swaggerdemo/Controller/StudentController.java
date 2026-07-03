package com.example.Swaggerdemo.Controller;

import com.example.Swaggerdemo.model.Student;
import com.example.Swaggerdemo.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@Tag(
    name = "Student API", 
    description = "Operations related to students")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping
    @Operation(summary = "Get All Students")
    public List<Student> getStudents() {
        return service.getStudents();
    }

    @PostMapping
    @Operation(summary = "Add New Student")
    public Student addStudent(@RequestBody Student student) {
        return service.addStudent(student);
    }
    @PutMapping("/{id}")
    @Operation(summary = "Update Student")
    public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
        return service.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Student")
    public String deleteStudent(@PathVariable int id) {
        service.deleteStudent(id);
        return "Student deleted successfully!";
    }
}