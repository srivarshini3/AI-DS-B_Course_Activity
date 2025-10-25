package com.example.studentservice.controller;

import com.example.studentservice.entity.StudentEntity;
import com.example.studentservice.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<StudentEntity> create(@Valid @RequestBody StudentEntity s) {
        StudentEntity created = service.createStudent(s);
        return ResponseEntity.created(URI.create("/api/students/" + created.getRegId())).body(created);
    }

    @GetMapping
    public List<StudentEntity> all() {
        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentEntity get(@PathVariable Long id) {
        return service.getStudentById(id);
    }

    @PutMapping("/{id}")
    public StudentEntity update(@PathVariable Long id, @Valid @RequestBody StudentEntity s) {
        return service.updateStudent(id, s);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
