package com.collegemgmt.facultyservice.service;

import com.collegemgmt.facultyservice.entity.FacultyEntity;
import java.util.List;

public interface FacultyService {
    FacultyEntity createFaculty(FacultyEntity faculty);
    List<FacultyEntity> getAllFaculties();
    FacultyEntity getFacultyById(Long id);
    FacultyEntity updateFaculty(Long id, FacultyEntity faculty);
    void deleteFaculty(Long id);
}
