package com.example.studentmanagmentsystem.service.impl;

import com.example.studentmanagmentsystem.dto.ResponseDto;
import com.example.studentmanagmentsystem.dto.StudentDto;
import com.example.studentmanagmentsystem.entity.Student;
import com.example.studentmanagmentsystem.repository.StudentRepo;
import com.example.studentmanagmentsystem.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public ResponseDto getAllStudent() {
        List<Student> studentList = studentRepo.findAll();
        if (studentList.isEmpty()){
            return new ResponseDto(01,"No Such Student Found",null);
        }
        return new ResponseDto(00,"Success",studentList);
    }

    @Override
    public ResponseDto deleteById(Long id) {
        if (studentRepo.existsById(id)){
            studentRepo.deleteById(id);
            return new ResponseDto(00,"Success",null);
        }
        return new ResponseDto(01,"No Such Student Found",null);
    }

    @Override
    public ResponseDto getAllStudentByYearOfEnrollment(int year) {

        Optional<List<Student>> studentList = studentRepo.findAllByYearOfEnrollment(year);
        if (studentList.isEmpty()){

            return new ResponseDto(01,"No Such Student Found",null);

        }
        return new ResponseDto(00,"Success",studentList);

    }

    @Override
    public ResponseDto getDepartmentByStudentId(Long studentId) {
        Optional<String> department = studentRepo.findDepartmentById(studentId);
        if (department.isEmpty()){
            return new ResponseDto(01,"No Such Department Found",null);
        }

        return new ResponseDto(00,"Success",department);
    }
}
