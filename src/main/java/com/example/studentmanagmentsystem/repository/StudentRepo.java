package com.example.studentmanagmentsystem.repository;

import com.example.studentmanagmentsystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Long> {
}
