package com.example.studentmanagmentsystem.service;

import com.example.studentmanagmentsystem.dto.ResponseDto;
import com.example.studentmanagmentsystem.dto.StudentDto;

public interface StudentService {
    ResponseDto addStudent(StudentDto studentDto);
}
