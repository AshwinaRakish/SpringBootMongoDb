package com.example.mongo_student.repository;

import com.example.mongo_student.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, String> {
}
