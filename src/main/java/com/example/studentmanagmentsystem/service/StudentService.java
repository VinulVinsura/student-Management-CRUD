package com.example.studentmanagmentsystem.service;

import com.example.studentmanagmentsystem.dto.ResponseDto;
import com.example.studentmanagmentsystem.dto.StudentDto;

public interface StudentService {
    ResponseDto addStudent(StudentDto studentDto);

    ResponseDto getAllStudent();

    ResponseDto deleteById(Long id);

    ResponseDto getAllStudentByYearOfEnrollment(int year);
    ResponseDto getDepartmentByStudentId(Long studentId);

    ResponseDto deleteStudentsByYearOfEnrollment(int yearOfEnroll);
}
