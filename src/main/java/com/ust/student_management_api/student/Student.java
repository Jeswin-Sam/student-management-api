package com.ust.student_management_api.student;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.time.Period;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {
    public Student(String name, LocalDate dateOfBirth, Gender gender, String email, Program program, Integer year, Department department, String phoneNumber) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.email = email;
        this.program = program;
        this.year = year;
        this.department = department;
        this.phoneNumber = phoneNumber;
    }

    public enum Gender {MALE, FEMALE, OTHER};
    public enum Program {BE, ME};
    public enum Department {CSE, ECE, EEE, CIVIL, MECH};

    @Id
    @SequenceGenerator(
            name = "studentId_sequence",
            sequenceName = "studentId_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "studentId_sequence")
    private Long id;
    private String name;
    private LocalDate dateOfBirth;

    @Transient
    private Integer age;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String email;

    @Enumerated(EnumType.STRING)
    private Program program;

    private Integer year;

    @Enumerated(EnumType.STRING)
    private Department department;

    private String phoneNumber;

    @Transient
    public Integer getAge() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

}
