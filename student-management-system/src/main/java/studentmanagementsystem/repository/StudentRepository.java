package studentmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import studentmanagementsystem.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {
    
}
