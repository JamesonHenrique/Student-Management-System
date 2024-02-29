package studentmanagementsystem.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
   
    private Long id;
    @NotEmpty(message = "Student first name should not be empty")
    private String firstName;
    @NotEmpty(message = "Student last name should not be empty")
    private String LastName;
    @NotEmpty(message = "Email address should not be empty")
    @Email()
    private String email;
}
