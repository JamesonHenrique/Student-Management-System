package studentmanagementsystem.service;

import java.util.List;

import studentmanagementsystem.dto.StudentDto;

public interface StudentService {
   List<StudentDto> getAllStudents();

void createStudent(StudentDto studentDto);

StudentDto getStudentById(Long studentId);


}
