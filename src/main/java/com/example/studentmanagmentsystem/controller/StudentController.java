package com.example.studentmanagmentsystem.controller;

import com.example.studentmanagmentsystem.dto.ResponseDto;
import com.example.studentmanagmentsystem.dto.StudentDto;
import com.example.studentmanagmentsystem.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/get-all-student")
    public ResponseEntity<ResponseDto> getAllStudent(){
        return ResponseEntity.ok(studentService.getAllStudent());
    }

    @DeleteMapping("/delete-by-id/{id}")
    public ResponseEntity<ResponseDto> deleteStudent(@PathVariable Long id){
        return ResponseEntity.ok(studentService.deleteById(id));
    }


    @GetMapping("/get-all-student-byYear/{year}")
    public ResponseEntity<ResponseDto> getAllStudent(@PathVariable int year){
        return ResponseEntity.ok(studentService.getAllStudentByYearOfEnrollment(year));
    }

    @GetMapping("/get-department-ByStudentId/{studentId}")
    public ResponseEntity<ResponseDto> getDepartmentByStudentId(@PathVariable Long studentId){
        return ResponseEntity.ok(studentService.getDepartmentByStudentId(studentId));
    }

    @DeleteMapping("/delete-ByYearOfEnrollment/{year}")
    public ResponseEntity<ResponseDto> deleteStudentsByYear(@PathVariable int year){
        return ResponseEntity.ok(studentService.deleteStudentsByYearOfEnrollment(year));
    }


}
