package com.example.Swaggerdemo.service;
import com.example.Swaggerdemo.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {List<Student> students = new ArrayList<>();

    public StudentService() {

        students.add(new Student(1,"Rahul","Java"));
        students.add(new Student(2,"Priya","Python"));
        students.add(new Student(3,"Kiran","React"));
    }

    public List<Student> getStudents() {
        return students;
    }

    public Student addStudent(Student student) {
        students.add(student);
        return student;
    }
    // PUT
    public Student updateStudent(int id, Student updatedStudent) {

        for (Student student : students) {
            if (student.getId() == id) {
                student.setName(updatedStudent.getName());
                student.setCourse(updatedStudent.getCourse());
                return student;
            }
        }
        return null;
    }

    // DELETE
    public void deleteStudent(int id) {

        students.removeIf(student -> student.getId() == id);
    }
    
}