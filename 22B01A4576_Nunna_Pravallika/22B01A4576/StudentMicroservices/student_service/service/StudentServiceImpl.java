package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.StudentEntity;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentEntity createStudent(StudentEntity student) {
        return studentRepository.save(student);
    }

    @Override
    public List<StudentEntity> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public StudentEntity getStudentById(Long id) {
        Optional<StudentEntity> optional = studentRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public StudentEntity updateStudent(Long id, StudentEntity student) {
        StudentEntity existingStudent = studentRepository.findById(id).orElse(null);
        if (existingStudent != null) {
            existingStudent.setRollNo(student.getRollNo());
            existingStudent.setName(student.getName());
            existingStudent.setDept(student.getDept());
            existingStudent.setSection(student.getSection());
            existingStudent.setAadharId(student.getAadharId());
            existingStudent.setSkills(student.getSkills());
            existingStudent.setCgpa(student.getCgpa());
            return studentRepository.save(existingStudent);
        } else {
            return null;
        }
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
