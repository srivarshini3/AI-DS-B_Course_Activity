package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.StudentEntity;

public interface StudentService {

    StudentEntity createStudent(StudentEntity student);
    List<StudentEntity> getAllStudents();
    StudentEntity getStudentById(Long id);
    StudentEntity updateStudent(Long id, StudentEntity student);
    void deleteStudent(Long id);
}
