package com.example.studentservice.service.impl;

import com.example.studentservice.entity.StudentEntity;
import com.example.studentservice.exception.ResourceNotFoundException;
import com.example.studentservice.repository.StudentRepository;
import com.example.studentservice.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    private final StudentRepository repo;

    public StudentServiceImpl(StudentRepository repo) {
        this.repo = repo;
    }

    @Override
    public StudentEntity createStudent(StudentEntity student) {
        return repo.save(student);
    }

    @Override
    public List<StudentEntity> getAllStudents() {
        return repo.findAll();
    }

    @Override
    public StudentEntity getStudentById(Long id) {
        return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found: " + id));
    }

    @Override
    public StudentEntity updateStudent(Long id, StudentEntity u) {
        StudentEntity e = getStudentById(id);
        e.setRollNo(u.getRollNo());
        e.setName(u.getName());
        e.setDept(u.getDept());
        e.setSection(u.getSection());
        e.setAadharId(u.getAadharId());
        e.setSkills(u.getSkills());
        e.setCgpa(u.getCgpa());
        return repo.save(e);
    }

    @Override
    public void deleteStudent(Long id) {
        StudentEntity e = getStudentById(id);
        repo.delete(e);
    }
}
