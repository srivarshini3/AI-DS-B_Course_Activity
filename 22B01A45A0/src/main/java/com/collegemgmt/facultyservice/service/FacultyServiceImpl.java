package com.collegemgmt.facultyservice.service;

import com.collegemgmt.facultyservice.entity.FacultyEntity;
import com.collegemgmt.facultyservice.repository.FacultyRepository;
import com.collegemgmt.facultyservice.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService {

    private final FacultyRepository facultyRepository;

    public FacultyServiceImpl(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @Override
    public FacultyEntity createFaculty(FacultyEntity faculty) {
        return facultyRepository.save(faculty);
    }

    @Override
    public List<FacultyEntity> getAllFaculties() {
        return facultyRepository.findAll();
    }

    @Override
    public FacultyEntity getFacultyById(Long id) {
        return facultyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Faculty not found with id: " + id));
    }

    @Override
    public FacultyEntity updateFaculty(Long id, FacultyEntity facultyDetails) {
        FacultyEntity faculty = getFacultyById(id);
        faculty.setName(facultyDetails.getName());
        faculty.setDept(facultyDetails.getDept());
        faculty.setDesignation(facultyDetails.getDesignation());
        faculty.setEmail(facultyDetails.getEmail());
        faculty.setPhoneNo(facultyDetails.getPhoneNo());
        return facultyRepository.save(faculty);
    }

    @Override
    public void deleteFaculty(Long id) {
        FacultyEntity faculty = getFacultyById(id);
        facultyRepository.delete(faculty);
    }
}
