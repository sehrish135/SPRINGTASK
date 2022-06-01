package com.example.CRUDSpring.service.impl;

import com.example.CRUDSpring.model.Courses;
import com.example.CRUDSpring.model.Teacher;

import java.util.List;


public interface TeacherService {
    Teacher saveTeacher(Teacher e);
    List<Teacher> getAllTeachers();
    Teacher getTeacherById(long id);
    Teacher UpdateTeacher(Teacher e,long id);
    void DeleteTeacher(long id);
}
