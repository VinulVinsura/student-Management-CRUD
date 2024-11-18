package com.example.studentmanagmentsystem.repository;

import com.example.studentmanagmentsystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<Student,Long> {


    Optional<List<Student>> findAllByYearOfEnrollment(int yearOfEnrollment);

    @Query("select s.department from Student s where s.id=:studentId")
    Optional<String> findDepartmentById(Long studentId);


}
