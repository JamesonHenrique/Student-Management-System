package studentmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;

import java.util.List;

import studentmanagementsystem.dto.StudentDto;
import studentmanagementsystem.service.StudentService;

@Controller
@AllArgsConstructor
public class StudentController {
    
    private StudentService studentService;
    @GetMapping("/students")
    public String listStudents(Model model) {
        List<StudentDto> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "students";
    }
    @GetMapping("/students/new")
    public String newStudent(Model model) {
        StudentDto studentDto = new StudentDto();
        model.addAttribute("students", studentDto);
        return "create-Student";
    }
}

        