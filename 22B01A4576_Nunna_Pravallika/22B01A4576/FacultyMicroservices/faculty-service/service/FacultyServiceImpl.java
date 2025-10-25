package com.example.demo.service;

import com.example.demo.entity.FacultyEntity;
import com.example.demo.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    private FacultyRepository repository;

    @Override
    public FacultyEntity createFaculty(FacultyEntity faculty) {
        return repository.save(faculty);
    }

    @Override
    public List<FacultyEntity> getAllFaculties() {
        return repository.findAll();
    }

    @Override
    public Optional<FacultyEntity> getFacultyById(Long id) {
        return repository.findById(id);
    }

    @Override
    public FacultyEntity updateFaculty(Long id, FacultyEntity faculty) {
        return repository.findById(id).map(existing -> {
            existing.setName(faculty.getName());
            existing.setDept(faculty.getDept());
            existing.setDesignation(faculty.getDesignation());
            existing.setEmail(faculty.getEmail());
            existing.setPhoneNo(faculty.getPhoneNo());
            return repository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Faculty not found with id " + id));
    }

    @Override
    public void deleteFaculty(Long id) {
        repository.deleteById(id);
    }
}
