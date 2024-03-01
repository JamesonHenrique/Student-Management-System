package studentmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
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
        model.addAttribute("student", studentDto);
        return "create-student";
    }
    @PostMapping("/students")
    public String saveStudent(@Valid @ModelAttribute("student") StudentDto studentDto,BindingResult result,Model model) {
        if (result.hasErrors()) {
            model.addAttribute("student", studentDto);
        }
        studentService.createStudent(studentDto);
        return "redirect:/students";
    }
    @GetMapping("/students/{studentId}/edit")
    public String editStudent(@PathVariable("studentId") Long studentId, Model model){
        StudentDto student = studentService.getStudentById(studentId);
        model.addAttribute("student", student);
        return "edit-Student";
    }
   
    
    @GetMapping("/students/{studentId}/delete")
    public String deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
        return "redirect:/students";
    }

    @PostMapping("/students/{studentId}")
    public String updateStudent(@PathVariable("studentId") Long studentId,
                                @Valid @ModelAttribute("student") StudentDto studentDto,
                                BindingResult result,
                                Model model){
        if(result.hasErrors()){
            model.addAttribute("student", studentDto);
            return "edit-Student";
        }
        studentDto.setId(studentId);
        studentService.updateStudent(studentDto);
        return "redirect:/students";
    }
    @GetMapping("/students/{studentId}/view")
    public String viewStudent(@PathVariable("studentId") Long studentId,
                              Model model){
        StudentDto studentDto = studentService.getStudentById(studentId);
        model.addAttribute("student", studentDto);
        return "view-student";
    }
}

        