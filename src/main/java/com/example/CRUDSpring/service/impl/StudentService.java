package com.example.CRUDSpring.service.impl;

import com.example.CRUDSpring.model.Student;

import java.util.List;


public interface StudentService {
    Student saveStudent(Student e);
    List<Student> getAllStudents();
    Student getStudentById(long id);
    Student UpdateStudent(Student e,long id);
    void DeleteStudent(long id);
}
