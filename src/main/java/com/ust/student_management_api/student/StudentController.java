package com.ust.student_management_api.student;

import com.ust.student_management_api.exceptions.RegisterNumberAlreadyExistsException;
import com.ust.student_management_api.exceptions.StudentNotFoundException;
import com.ust.student_management_api.response.ApiResponse;
import com.ust.student_management_api.student.Student;
import com.ust.student_management_api.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
@CrossOrigin(origins = "*")
public class StudentController {
    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }




    @GetMapping
    public ResponseEntity<ApiResponse<List<Student>>> getAllStudents() {
        ApiResponse<List<Student>> response = new ApiResponse<>(
                "Success",
                200,
                "Student list fetched successfully",
                studentService.getAllStudents()
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Get student by ID
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Student>> getStudentById(@PathVariable Long id) {
        ApiResponse<Student> response = new ApiResponse<>(
                "Success",
                200,
                "Student fetched successfully",
                studentService.getStudentById(id)
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Add new student
    @PostMapping("/add")
    public ResponseEntity<ApiResponse<Student>> createStudent(@RequestBody Student student) throws RegisterNumberAlreadyExistsException {
        ApiResponse<Student> response = new ApiResponse<>(
                "Success",
                201,
                "New student added successfully",
                studentService.addStudent(student)
        );
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Update student
    @PutMapping("/update")
    public ResponseEntity<ApiResponse<Student>> updateStudent(
            @RequestBody Student updatedStudent
    ) {
        Student result = studentService.updateStudent(updatedStudent);

        ApiResponse<Student> response = new ApiResponse<>(
                "Updated",
                200,
                "Student " + updatedStudent.getId() + " updated successfully!",
                result
        );
        return ResponseEntity.ok(response);
    }


    // Delete student
    @DeleteMapping("delete/{id}")
    public ResponseEntity<ApiResponse<String>> deleteStudent(@PathVariable Long id) throws StudentNotFoundException {
        studentService.deleteStudent(id);
        ApiResponse<String> response = new ApiResponse<>(
                "Deleted",
                204,
                "Student " + id + " deleted successfully!",
                "No content"
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
