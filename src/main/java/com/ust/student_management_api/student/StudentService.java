package com.ust.student_management_api.student;

import com.ust.student_management_api.exceptions.RegisterNumberAlreadyExistsException;
import com.ust.student_management_api.exceptions.StudentNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        if (studentRepository.findById(id).isPresent()) {
            return studentRepository.findById(id).get();
        }
        throw new EntityNotFoundException("Student not found with ID: " + id);
    }

    public Student addStudent(Student student) throws RegisterNumberAlreadyExistsException {
        validateStudent(student);
        return studentRepository.save(student);
    }

    public Student updateStudent(Student updatedStudent) {
        if (studentRepository.findById(updatedStudent.getId()).isPresent()) {
            Student existingStudent = studentRepository.findById(updatedStudent.getId()).get();


//            validateStudent(updatedStudent);
            return studentRepository.save(updatedStudent);
        } else {
            throw new EntityNotFoundException("Student not found with ID: " + updatedStudent.getId());
        }
    }


    public void deleteStudent(Long id) throws StudentNotFoundException {
        if (studentRepository.findById(id).isPresent()) {
            studentRepository.deleteById(id);
        }
        else {
            throw new StudentNotFoundException("Student not found with ID: " + id);
        }
    }

    private void validateStudent(Student student) {

        if (student.getName() == null)
            throw new IllegalArgumentException("Name is required");

        if (student.getDateOfBirth() == null)
            throw new IllegalArgumentException("Date of birth is required");

        if (student.getGender() == null)
            throw new IllegalArgumentException("Gender is required");

        if (student.getEmail() == null || !student.getEmail().matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$"))
            throw new IllegalArgumentException("Valid email is required");

        if (student.getProgram() == null)
            throw new IllegalArgumentException("Program is required");

        if (student.getYear() == null || student.getYear() < 2010 || student.getYear() > LocalDate.now().getYear())
            throw new IllegalArgumentException("Valid admission year is required");

        if (student.getDepartment() == null)
            throw new IllegalArgumentException("Department is required");

        if (student.getPhoneNumber() == null || !student.getPhoneNumber().matches("\\d{10}"))
            throw new IllegalArgumentException("Valid phone number is required");

        int age = LocalDate.now().getYear() - student.getDateOfBirth().getYear();
        if (age < 16)
            throw new IllegalArgumentException("Student must be at least 16 years old");
    }

}
