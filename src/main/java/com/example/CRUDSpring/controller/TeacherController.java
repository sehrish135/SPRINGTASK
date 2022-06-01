package com.example.CRUDSpring.controller;


import com.example.CRUDSpring.model.Courses;
import com.example.CRUDSpring.model.Teacher;
import com.example.CRUDSpring.service.impl.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

public class TeacherController {
    @Autowired
    private TeacherService TeacherService;
    Long idv;
    public TeacherController(TeacherService TeacherService)
    {
        super();
        this.TeacherService=TeacherService;
    }
    //View list of Courses
    @RequestMapping("/teacher")
    public String viewHomePage(Model m)
    {
         m.addAttribute("listTeacher", TeacherService.getAllTeachers());
         return "teacher";
    }
    @RequestMapping( "/newTeacherForm")
    public String showNewCoursesForm(Model m)
    {
        Teacher Teacher=new Teacher();
        m.addAttribute("Teacher",Teacher);
        return "new_teacher";
    }
    @PostMapping("/assignCourseTeacher")
    public ResponseEntity<Teacher> assignCourses (@RequestBody Teacher e)
    {
      return new ResponseEntity<Teacher>(TeacherService.saveTeacher(e), HttpStatus.CREATED);
    }
    @GetMapping("/findAllValues")
    public List<Teacher> findAllMap()
    {
        return TeacherService.getAllTeachers();
    }

    //Build create REST API
//    @PostMapping()
//    public ResponseEntity<Teacher> saveTeacher(@RequestBody Teacher e)
//    {
//        return new ResponseEntity<Teacher>(TeacherService.saveTeacher(e), HttpStatus.CREATED);
//    }

    @PostMapping("/saveTeacher")
    public String saveTeacher(@ModelAttribute("Teacher") Teacher e)
    {
        TeacherService.saveTeacher(e);
        return "redirect:/teacher";
    }
    @GetMapping("/showTeacherUpdate/{id}")
    public String showFormUpdate(@PathVariable(value = "id")long id,@ModelAttribute("Teacher") Teacher eu,Model m)
    {
    //Get Teacher from service
        Teacher e=TeacherService.getTeacherById(id);
        idv=id;
       // Teacher Teacher=new Teacher();
        m.addAttribute("Teacher",e);
        return "update_teach";

    }

    @GetMapping("/showDeleteTeach/{id}")
    public String deleteEmp(@PathVariable(value="id") long id)
    {
        TeacherService.DeleteTeacher(id);
        return "redirect:/teacher";
    }
    @PostMapping("/FormTeachUpdate")
    public String updatedCourses(@ModelAttribute("Teacher") Teacher e) {
        Teacher updatedEmpl = TeacherService.UpdateTeacher(e,idv);
        return "redirect:/teacher";
    }
    //Build get all Teacher REST API
//    @GetMapping
//    public List<Teacher> getAllTeacher()
//    {
//        return TeacherService.getAllTeachers();
//    }
/*    public ResponseEntity<Teacher> getTeacherById(@PathVariable("id") long Teacherid)
    {
          return new ResponseEntity<Teacher>(TeacherService.getTeacherById(Teacherid),HttpStatus.OK);
    }*/
    //Build API to update Teacher record
//    @PutMapping("{id}")
//    public ResponseEntity<Teacher>UpdateEmployee(@PathVariable("id")long id,
//                                                  @RequestBody Employee e)
//    {
//        return new ResponseEntity<Employee>(employeeService.UpdateEmployee(e,id),HttpStatus.OK);
//    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> DeleteEmployee(@PathVariable("id") long id)
    {
        TeacherService.DeleteTeacher(id);
        return new ResponseEntity<String>("Deleted Successfully",HttpStatus.OK);
    }

}
