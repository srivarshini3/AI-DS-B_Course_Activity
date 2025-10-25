package com.example.demo.controller;

import com.example.demo.entity.FacultyEntity;
import com.example.demo.service.FacultyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/faculties")
public class FacultyController {

    @Autowired
    private FacultyService service;

    @PostMapping
    public ResponseEntity<FacultyEntity> createFaculty(@Valid @RequestBody FacultyEntity faculty) {
        return ResponseEntity.ok(service.createFaculty(faculty));
    }

    @GetMapping
    public ResponseEntity<List<FacultyEntity>> getAllFaculties() {
        return ResponseEntity.ok(service.getAllFaculties());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacultyEntity> getFacultyById(@PathVariable Long id) {
        return service.getFacultyById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<FacultyEntity> updateFaculty(@PathVariable Long id, @Valid @RequestBody FacultyEntity faculty) {
        return ResponseEntity.ok(service.updateFaculty(id, faculty));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFaculty(@PathVariable Long id) {
        service.deleteFaculty(id);
        return ResponseEntity.noContent().build();
    }
}
