package com.example.CRUDSpring.controller;


import com.example.CRUDSpring.model.Student;
import com.example.CRUDSpring.service.impl.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller

public class StudentController {
    @Autowired
    private StudentService StudentService;
    Long idv;
    public StudentController(StudentService StudentService)
    {
        super();
        this.StudentService=StudentService;
    }
    //View list of Students
    @RequestMapping("/")
    public String viewHomePage(Model m)
    {
         m.addAttribute("listStudent",StudentService.getAllStudents());
         return "index";
    }
    @RequestMapping( "/newStudentForm")
    public String showNewStudentForm(Model m)
    {
        Student Student=new Student();
        m.addAttribute("Student",Student);
        return "new_Student";
    }

    //Build create REST API
//    @PostMapping()
//    public ResponseEntity<Student> saveStudent(@RequestBody Student e)
//    {
//        return new ResponseEntity<Student>(StudentService.saveStudent(e), HttpStatus.CREATED);
//    }

    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("Student") Student e)
    {
        StudentService.saveStudent(e);
        return "redirect:/";
    }
    @GetMapping("/showFormUpdate/{id}")
    public String showFormUpdate(@PathVariable(value = "id")long id,@ModelAttribute("Student") Student eu,Model m)
    {
    //Get Student from service
        Student e=StudentService.getStudentById(id);
        idv=id;
       // Student Student=new Student();
        m.addAttribute("Student",e);
        return "update_stud";

    }
    @PostMapping("/FormUpdate")
    public String updatedStudent(@ModelAttribute("Student") Student e) {
        Student updatedEmpl = StudentService.UpdateStudent(e,idv);
        return "redirect:/";
    }
    @GetMapping("/showDelete/{id}")
    public String deleteEmp(@PathVariable(value="id") long id)
    {
        StudentService.DeleteStudent(id);
        return "redirect:/";
    }
    //Build get all Student REST API
//    @GetMapping
//    public List<Student> getAllStudent()
//    {
//        return StudentService.getAllStudents();
//    }
    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") long Studentid)
    {
          return new ResponseEntity<Student>(StudentService.getStudentById(Studentid),HttpStatus.OK);
    }
    //Build API to update Student record
//    @PutMapping("{id}")
//    public ResponseEntity<Student>UpdateEmployee(@PathVariable("id")long id,
//                                                  @RequestBody Employee e)
//    {
//        return new ResponseEntity<Employee>(employeeService.UpdateEmployee(e,id),HttpStatus.OK);
//    }

//    @DeleteMapping("{id}")
//    public ResponseEntity<String> DeleteEmployee(@PathVariable("id") long id)
//    {
//        employeeService.DeleteEmployee(id);
//        return new ResponseEntity<String>("Deleted Successfully",HttpStatus.OK);
//    }

}
