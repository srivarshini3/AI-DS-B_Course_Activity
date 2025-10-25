package com.example.studentservice.service;

import com.example.studentservice.entity.StudentEntity;
import java.util.List;

public interface StudentService {
    StudentEntity createStudent(StudentEntity student);

    List<StudentEntity> getAllStudents();

    StudentEntity getStudentById(Long id);

    StudentEntity updateStudent(Long id, StudentEntity student);

    void deleteStudent(Long id);
}
