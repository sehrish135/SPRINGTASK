package com.example.CRUDSpring.service.impl;


import com.example.CRUDSpring.exception.ResourceNotFound;
import com.example.CRUDSpring.model.Student;
import com.example.CRUDSpring.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{
    private StudentRepository StudentRepository;

   //No need to add Autowired because by default adding one constructor, it will be autowired
    public StudentServiceImpl(StudentRepository StudentRepository) {
        this.StudentRepository = StudentRepository;
    }


    @Override
    public Student saveStudent(Student e) {
        return StudentRepository.save(e);
    }

    @Override
    public List<Student> getAllStudents() {
        return StudentRepository.findAll();
    }

    @Override
    public Student getStudentById(long id) {
        Optional<Student> e= StudentRepository.findById(id);
        if(e.isPresent())
        {
            return e.get();
        }
        else
        {
            throw new ResourceNotFound("Student","id","id");
        }
    }

    @Override
    public Student UpdateStudent(Student e, long id) {

        Student em =StudentRepository.findById(id).orElseThrow(()
                            ->new ResourceNotFound("Student","id","id"));

        em.setFirstName(e.getFirstName());
        em.setLastName(e.getLastName());
        em.setEmail(e.getEmail());
        //save existing Student to database

        StudentRepository.save(em);
        return em;
    }

    @Override
    public void DeleteStudent(long id) {
        Student em =StudentRepository.findById(id).orElseThrow(()
                ->new ResourceNotFound("Student","id","id"));
        StudentRepository.deleteById(id);

    }
}
