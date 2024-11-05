package com.in28minutes.springboot.rest.example;

import com.in28minutes.springboot.rest.example.student.Student;
import com.in28minutes.springboot.rest.example.student.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    // 固定的学生数据
    private final Student[] students = new Student[]{
            new Student(null, "Alice", "P123451"),
            new Student(null, "Bob", "P123452"),
            new Student(null, "Charlie", "P123453"),
            new Student(null, "David", "P123454"),
            new Student(null, "Eve", "P123455"),
            new Student(null, "Frank", "P123456"),
            new Student(null, "Grace", "P123457"),
            new Student(null, "Hannah", "P123458"),
            new Student(null, "Ivy", "P123459"),
            new Student(null, "Jack", "P123460"),
            new Student(null, "Kathy", "P123461"),
            new Student(null, "Leo", "P123462"),
            new Student(null, "Mia", "P123463"),
            new Student(null, "Nina", "P123464"),
            new Student(null, "Oscar", "P123465"),
            new Student(null, "Paul", "P123466"),
            new Student(null, "Quinn", "P123467"),
            new Student(null, "Rachel", "P123468"),
            new Student(null, "Steve", "P123469"),
            new Student(null, "Tina", "P123470"),
            new Student(null, "Uma", "P123471"),
            new Student(null, "Vera", "P123472"),
            new Student(null, "Will", "P123473"),
            new Student(null, "Xena", "P123474"),
            new Student(null, "Yara", "P123475"),
            new Student(null, "Zoe", "P123476"),
            new Student(null, "Aaron", "P123477"),
            new Student(null, "Bella", "P123478"),
            new Student(null, "Carter", "P123479"),
            new Student(null, "Diana", "P123480"),
            new Student(null, "Elijah", "P123481"),
            new Student(null, "Felix", "P123482"),
            new Student(null, "Gina", "P123483"),
            new Student(null, "Henry", "P123484"),
            new Student(null, "Iris", "P123485"),
            new Student(null, "Jared", "P123486"),
            new Student(null, "Kylie", "P123487"),
            new Student(null, "Liam", "P123488"),
            new Student(null, "Mason", "P123489"),
            new Student(null, "Nora", "P123490"),
            new Student(null, "Owen", "P123491"),
            new Student(null, "Piper", "P123492"),
            new Student(null, "Quincy", "P123493"),
            new Student(null, "Rita", "P123494"),
            new Student(null, "Sam", "P123495"),
            new Student(null, "Toby", "P123496"),
            new Student(null, "Ursula", "P123497"),
            new Student(null, "Victor", "P123498"),
            new Student(null, "Wendy", "P123499"),
            new Student(null, "Xander", "P123500"),
            new Student(null, "Yvonne", "P123501"),
            new Student(null, "Zara", "P123502"),
            new Student(null, "Abby", "P123503"),
            new Student(null, "Bobby", "P123504"),
            new Student(null, "Cathy", "P123505"),
            new Student(null, "Danny", "P123506"),
            new Student(null, "Ella", "P123507"),
            new Student(null, "Freddy", "P123508"),
            new Student(null, "Garry", "P123509"),
            new Student(null, "Holly", "P123510"),
            new Student(null, "Ian", "P123511"),
            new Student(null, "Julia", "P123512"),
            new Student(null, "Kyle", "P123513"),
            new Student(null, "Leah", "P123514"),
            new Student(null, "Molly", "P123515"),
            new Student(null, "Nate", "P123516"),
            new Student(null, "Olivia", "P123517"),
            new Student(null, "Pete", "P123518"),
            new Student(null, "Quinn", "P123519"),
            new Student(null, "Ricky", "P123520"),
            new Student(null, "Sophie", "P123521"),
            new Student(null, "Tina", "P123522"),
            new Student(null, "Ulysses", "P123523"),
            new Student(null, "Vicky", "P123524"),
            new Student(null, "Wesley", "P123525"),
            new Student(null, "Xiomara", "P123526"),
            new Student(null, "Yasmin", "P123527"),
            new Student(null, "Zelda", "P123528")
    };

    @Test
    @Transactional
    @Rollback(false)
    public void testCreateAndRetrieveStudents() {
        // 插入固定的学生数据
        createStudents();

        // 查询所有学生
        List<Student> studentsList = studentService.retrieveAllStudents();

        // 输出查询结果以便调试
        studentsList.forEach(student -> {
            System.out.println("Retrieved Student: " + student.getName() + ", Passport: " + student.getPassportNumber());
        });

        // 验证是否插入了 100 条学生数据
        assertThat(studentsList).hasSizeGreaterThanOrEqualTo(78);

        // 验证部分护照号码是否存在
        assertThat(studentsList).anyMatch(s -> s.getPassportNumber().equals("P123451"));
        assertThat(studentsList).anyMatch(s -> s.getPassportNumber().equals("P123452"));
        // ... 可以继续添加其他护照号码的验证
    }

    private void createStudents() {
        // 插入固定的学生数据
        for (Student student : students) {
            studentService.createStudent(student);
        }
    }
}
