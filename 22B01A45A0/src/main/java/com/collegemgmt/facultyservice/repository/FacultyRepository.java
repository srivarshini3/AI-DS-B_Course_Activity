package com.collegemgmt.facultyservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.collegemgmt.facultyservice.entity.FacultyEntity;

public interface FacultyRepository extends JpaRepository<FacultyEntity, Long> {
}
