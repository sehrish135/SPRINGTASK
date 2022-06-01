package com.example.CRUDSpring.service.impl;

import com.example.CRUDSpring.model.Courses;

import java.util.List;


public interface CoursesService {
    Courses saveCourses(Courses e);
    List<Courses> getAllCourses();
    Courses getCoursesById(long id);
    Courses UpdateCourses(Courses e,long id);
    void DeleteCourses(long id);
}
