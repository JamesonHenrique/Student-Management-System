package studentmanagementsystem.service;

import java.util.List;

import jakarta.validation.Valid;
import studentmanagementsystem.dto.StudentDto;

public interface StudentService {
   List<StudentDto> getAllStudents();

void createStudent(StudentDto studentDto);

StudentDto getStudentById(Long studentId);

void updateStudent(@Valid StudentDto studentDto);

void deleteStudent(Long studentId);



}
