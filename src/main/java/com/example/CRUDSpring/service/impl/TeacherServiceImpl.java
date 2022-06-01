package com.example.CRUDSpring.service.impl;


import com.example.CRUDSpring.exception.ResourceNotFound;
import com.example.CRUDSpring.model.Teacher;
import com.example.CRUDSpring.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService{
    private TeacherRepository TeacherRepository;

   //No need to add Autowired because by default adding one constructor, it will be autowired
    public TeacherServiceImpl(TeacherRepository TeacherRepository) {
        this.TeacherRepository = TeacherRepository;
    }


    @Override
    public Teacher saveTeacher(Teacher e) {
        return TeacherRepository.save(e);
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return TeacherRepository.findAll();
    }

    @Override
    public Teacher getTeacherById(long id) {
        Optional<Teacher> e= TeacherRepository.findById(id);
        if(e.isPresent())
        {
            return e.get();
        }
        else
        {
            throw new ResourceNotFound("Teacher","id","id");
        }
    }

    @Override
    public Teacher UpdateTeacher(Teacher e, long id) {

        Teacher em =TeacherRepository.findById(id).orElseThrow(()
                            ->new ResourceNotFound("Teacher","id","id"));

        em.setFirstName(e.getFirstName());
        em.setLastName(e.getLastName());
        em.setEmail(e.getEmail());
        //save existing Teacher to database

        TeacherRepository.save(em);
        return em;
    }

    @Override
    public void DeleteTeacher(long id) {
        Teacher em =TeacherRepository.findById(id).orElseThrow(()
                ->new ResourceNotFound("Teacher","id","id"));
        TeacherRepository.deleteById(id);

    }
}
