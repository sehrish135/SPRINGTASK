package com.example.CRUDSpring.service.impl;


import com.example.CRUDSpring.exception.ResourceNotFound;
import com.example.CRUDSpring.model.Courses;
import com.example.CRUDSpring.repository.CoursesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CoursesService{
    private CoursesRepository CoursesRepository;

   //No need to add Autowired because by default adding one constructor, it will be autowired
    public CourseServiceImpl(CoursesRepository CoursesRepository) {
        this.CoursesRepository = CoursesRepository;
    }


    @Override
    public Courses saveCourses(Courses e) {
        return CoursesRepository.save(e);
    }

    @Override
    public List<Courses> getAllCourses() {
        return CoursesRepository.findAll();
    }

    @Override
    public Courses getCoursesById(long id) {
        Optional<Courses> e= CoursesRepository.findById(id);
        if(e.isPresent())
        {
            return e.get();
        }
        else
        {
            throw new ResourceNotFound("Courses","id","id");
        }
    }

    @Override
    public Courses UpdateCourses(Courses e, long id) {

        Courses em =CoursesRepository.findById(id).orElseThrow(()
                            ->new ResourceNotFound("Courses","id","id"));

        em.setCourseCode(e.getCourseCode());
        em.setCourseName(e.getCourseName());
        em.setDescription(e.getDescription());
        //save existing Courses to database

        CoursesRepository.save(em);
        return em;
    }

    @Override
    public void DeleteCourses(long id) {
        Courses em =CoursesRepository.findById(id).orElseThrow(()
                ->new ResourceNotFound("Courses","id","id"));
        CoursesRepository.deleteById(id);

    }
}
