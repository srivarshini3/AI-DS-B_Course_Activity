package com.example.studentservice.repository;

import com.example.studentservice.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    Optional<StudentEntity> findByRollNo(String rollNo);

    boolean existsByAadharId(String aadharId);
}
