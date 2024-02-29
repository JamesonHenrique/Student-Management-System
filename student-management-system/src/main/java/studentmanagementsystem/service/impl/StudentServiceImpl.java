package studentmanagementsystem.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import studentmanagementsystem.dto.StudentDto;
import studentmanagementsystem.entity.Student;
import studentmanagementsystem.mapper.StudentMapper;
import studentmanagementsystem.repository.StudentRepository;
import studentmanagementsystem.service.StudentService;
@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;
    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentDto> studentDtos = students.stream()
                .map((student) -> StudentMapper.mapToStudentDto(student))
                .collect(Collectors.toList());
        return studentDtos;
    }
    @Override
    public void createStudent(StudentDto studentDto) {
       Student student = StudentMapper.mapToStudent(studentDto);
       studentRepository.save(student);
    }

    
}