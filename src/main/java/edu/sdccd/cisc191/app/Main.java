package edu.sdccd.cisc191.app;

import edu.sdccd.cisc191.model.Course;
import edu.sdccd.cisc191.model.Student;
import edu.sdccd.cisc191.repository.CourseRepository;
import edu.sdccd.cisc191.repository.JdbcCourseRepository;
import edu.sdccd.cisc191.repository.JdbcStudentRepository;
import edu.sdccd.cisc191.repository.StudentRepository;
import edu.sdccd.cisc191.service.StudentService;
import edu.sdccd.cisc191.util.DatabaseInitializer;

public class Main {
    public static void main(String[] args) {
        // TODO initialize database
        DatabaseInitializer.initialize();

        // TODO create student service and repositories
        StudentRepository studentRepository = new JdbcStudentRepository();
        CourseRepository courseRepository = new JdbcCourseRepository();

        StudentService studentService = new StudentService(studentRepository);

        // TODO add at least 3 students
        Student s1 = new Student(1, "Jessie", 3.8);
        Student s2 = new Student(2, "James", 3.2);
        Student s3 = new Student(3, "John", 3.9);

        studentService.addStudent(s1);
        studentService.addStudent(s2);
        studentService.addStudent(s3);

        // TODO add at least 3 courses linked to students
        courseRepository.save(new Course(1, "Math", 1));
        courseRepository.save(new Course(2, "Physics", 1));
        courseRepository.save(new Course(3, "Programming", 2));

        // TODO print all students
        System.out.println("All Students:");
        studentService.getAllStudents().forEach(System.out::println);

        // TODO find one student by ID
        System.out.println("\nFind Student ID 1:");
        System.out.println(studentService.getStudent(1));

        // TODO print courses for a student
        System.out.println("\nCourses for Student 1:");
        courseRepository.findByStudentId(1).forEach(System.out::println);

        // TODO update one GPA
        studentService.changeGpa(2, 3.7);

        // TODO delete one student
        studentService.removeStudent(3);

        // TODO print remaining students and courses
        System.out.println("\nRemaining Students:");
        studentService.getAllStudents().forEach(System.out::println);

        System.out.println("\nAll Courses:");
        courseRepository.findAll().forEach(System.out::println);
    }
}
