package com.example.studentmanagmentsystem.controller;

import com.example.studentmanagmentsystem.dto.ResponseDto;
import com.example.studentmanagmentsystem.dto.StudentDto;
import com.example.studentmanagmentsystem.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/add-student")
    public ResponseEntity<ResponseDto> addStudent(@RequestBody StudentDto studentDto){
        return ResponseEntity.ok(studentService.addStudent(studentDto));
    }

}