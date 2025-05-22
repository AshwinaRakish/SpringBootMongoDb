package com.example.mongo_student.controller;

import com.example.mongo_student.entity.Student;
import com.example.mongo_student.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    final private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudentEntry(@RequestBody Student student){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.studentService.saveStudent(student));
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents(){
        return ResponseEntity.ok(this.studentService.getAllStudent());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable String id){
        Student student = this.studentService.getStudentById(id).orElseThrow();
        return ResponseEntity.ok(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudentById(@PathVariable String id, @RequestBody Student student)
    {
        this.studentService.getStudentById(id).orElseThrow();
        student.setId(id);
        return ResponseEntity.ok(this.studentService.saveStudent(student));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudentById(@PathVariable String id){
        this.studentService.getStudentById(id).orElseThrow();
        this.studentService.deleteStudentById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
