package com.example.mongo_student.service;
import com.example.mongo_student.entity.Student;
import com.example.mongo_student.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    final private StudentRepository StudentRepository;

    public StudentService(StudentRepository StudentRepository) {
        this.StudentRepository = StudentRepository;
    }

    public Student saveStudent(Student Student){
        return this.StudentRepository.save(Student);
    }

    public List<Student> getAllStudent(){
        return this.StudentRepository.findAll();
    }

    public Optional<Student> getStudentById(String id){
        return this.StudentRepository.findById(id);
    }

    public void deleteStudentById(String id){
        this.StudentRepository.deleteById(id);
    }
}
