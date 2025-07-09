package com.ust.student_management_api.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student sam = new Student(
                    "Sam Sundar",
                    LocalDate.of(2001, 10, 28),
                    Student.Gender.MALE,
                    "sam.sundar@gmail.com",
                    Student.Program.BE,
                    1,
                    Student.Department.CSE,
                    "9876543210"
            );

            Student priya = new Student(
                    "Priya Sharma",
                    LocalDate.of(2002, 5, 12),
                    Student.Gender.FEMALE,
                    "priya.sharma@gmail.com",
                    Student.Program.ME,
                    2,
                    Student.Department.ECE,
                    "9123456780"
            );

            Student arun = new Student(
                    "Arun Raj",
                    LocalDate.of(2000, 8, 19),
                    Student.Gender.MALE,
                    "arun.raj@gmail.com",
                    Student.Program.BE,
                    3,
                    Student.Department.MECH,
                    "9786543210"
            );

            Student kavya = new Student(
                    "Kavya Iyer",
                    LocalDate.of(2001, 1, 5),
                    Student.Gender.FEMALE,
                    "kavya.iyer@gmail.com",
                    Student.Program.ME,
                    4,
                    Student.Department.CSE,
                    "9871234560"
            );

            Student vishal = new Student(
                    "Vishal Reddy",
                    LocalDate.of(1999, 11, 23),
                    Student.Gender.MALE,
                    "vishal.reddy@gmail.com",
                    Student.Program.BE,
                    1,
                    Student.Department.EEE,
                    "9567890123"
            );

            Student sneha = new Student(
                    "Sneha Patil",
                    LocalDate.of(2002, 2, 17),
                    Student.Gender.FEMALE,
                    "sneha.patil@gmail.com",
                    Student.Program.ME,
                    2,
                    Student.Department.CSE,
                    "9654321870"
            );

            Student rohit = new Student(
                    "Rohit Kumar",
                    LocalDate.of(2000, 6, 14),
                    Student.Gender.MALE,
                    "rohit.kumar@gmail.com",
                    Student.Program.BE,
                    3,
                    Student.Department.CIVIL,
                    "9876501234"
            );

            Student meera = new Student(
                    "Meera Nair",
                    LocalDate.of(2001, 9, 10),
                    Student.Gender.FEMALE,
                    "meera.nair@gmail.com",
                    Student.Program.ME,
                    4,
                    Student.Department.CSE,
                    "9745612300"
            );

            Student ankit = new Student(
                    "Ankit Singh",
                    LocalDate.of(2002, 3, 8),
                    Student.Gender.MALE,
                    "ankit.singh@gmail.com",
                    Student.Program.BE,
                    1,
                    Student.Department.ECE,
                    "9123067890"
            );

            Student diya = new Student(
                    "Diya Menon",
                    LocalDate.of(1999, 12, 25),
                    Student.Gender.FEMALE,
                    "diya.menon@gmail.com",
                    Student.Program.ME,
                    2,
                    Student.Department.ECE,
                    "9456783210"
            );

            Student raj = new Student(
                    "Raj Malhotra",
                    LocalDate.of(2000, 4, 30),
                    Student.Gender.MALE,
                    "raj.malhotra@gmail.com",
                    Student.Program.BE,
                    3,
                    Student.Department.MECH,
                    "9812345678"
            );

            Student aarti = new Student(
                    "Aarti Joshi",
                    LocalDate.of(2001, 7, 2),
                    Student.Gender.FEMALE,
                    "aarti.joshi@gmail.com",
                    Student.Program.ME,
                    4,
                    Student.Department.CSE,
                    "9988776655"
            );



            repository.saveAll(List.of(sam, priya, arun, kavya, vishal, sneha, rohit, meera, ankit, diya, raj, aarti
            ));
        };
    }

}

