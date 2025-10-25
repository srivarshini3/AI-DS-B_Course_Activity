package com.example.demo.service;

import com.example.demo.entity.FacultyEntity;

import java.util.List;
import java.util.Optional;

public interface FacultyService {

    FacultyEntity createFaculty(FacultyEntity faculty);

    List<FacultyEntity> getAllFaculties();

    Optional<FacultyEntity> getFacultyById(Long id);

    FacultyEntity updateFaculty(Long id, FacultyEntity faculty);

    void deleteFaculty(Long id);
}
