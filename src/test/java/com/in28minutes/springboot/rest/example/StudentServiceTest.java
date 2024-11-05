package com.in28minutes.springboot.rest.example;

import com.in28minutes.springboot.rest.example.student.Student;
import com.in28minutes.springboot.rest.example.student.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void testCreateAndRetrieveStudent() {
        // 插入一名学生
        Student student = new Student(null, "John Doe", "P1234567");
        studentService.createStudent(student);

        // 查询所有学生
        List<Student> students = studentService.retrieveAllStudents();

        // 验证学生列表中是否包含插入的学生
        assertThat(students).anyMatch(s -> s.getName().equals("John Doe"));
    }
}
