package com.example.studentmanagmentsystem.service.impl;

import com.example.studentmanagmentsystem.dto.ResponseDto;
import com.example.studentmanagmentsystem.dto.StudentDto;
import com.example.studentmanagmentsystem.entity.Student;
import com.example.studentmanagmentsystem.repository.StudentRepo;
import com.example.studentmanagmentsystem.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;
    private final ModelMapper mapper;

    @Override
    public ResponseDto addStudent(StudentDto studentDto) {
        if (studentRepo.existsById(studentDto.getId())){
            return new ResponseDto(04,"Student Already Exists",null);
        }
        studentRepo.save(mapper.map(studentDto, Student.class));
        return new ResponseDto(00,"Success",null);

    }
}
