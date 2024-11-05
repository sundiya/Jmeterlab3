package com.in28minutes.springboot.rest.example.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.cache.annotation.Cacheable; // 引入缓存注解

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> retrieveAllStudents() {
        return studentRepository.findAll();
    }

    @Cacheable(value = "students", key = "#id") // 缓存该方法的结果
    public Optional<Student> retrieveStudent(Long id) {
        return studentRepository.findById(id);
    }

    @Transactional
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Transactional // 确保更新操作是事务性的
    public Student updateStudent(Long id, Student student) {
        student.setId(id);
        return studentRepository.save(student);
    }
}
