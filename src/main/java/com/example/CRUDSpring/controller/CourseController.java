package com.example.CRUDSpring.controller;


import com.example.CRUDSpring.model.Courses;
import com.example.CRUDSpring.service.impl.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

public class CourseController {
    @Autowired
    private CoursesService CoursesService;
    Long idv;

    public CourseController(CoursesService CoursesService) {
        super();
        this.CoursesService = CoursesService;
    }

    //View list of Courses
    @RequestMapping("/courses")
    public String viewHomePage(Model m) {
        m.addAttribute("listCourses", CoursesService.getAllCourses());
        return "courses";
    }

    @RequestMapping("/newCoursesForm")
    public String showNewCoursesForm(Model m) {
        Courses Courses = new Courses();
        m.addAttribute("Courses", Courses);
        return "new_course";
    }

    @PostMapping("/saveCourses")
    public String saveCourses(@ModelAttribute("Courses") Courses e) {
        CoursesService.saveCourses(e);
        return "redirect:/courses";
    }

    @GetMapping("/showCourseUpdate/{id}")
    public String showFormUpdate(@PathVariable(value = "id") long id, @ModelAttribute("Courses") Courses eu, Model m) {
        //Get Courses from service
        Courses e = CoursesService.getCoursesById(id);
        idv = id;
        // Courses Courses=new Courses();
        m.addAttribute("Courses", e);
        return "update_course";

    }

    @PostMapping("/CoursesFormUpdate")
    public String updatedCourses(@ModelAttribute("Courses") Courses e) {
        Courses updatedEmp = CoursesService.UpdateCourses(e, idv);
        return "redirect:/courses";
    }

    @GetMapping("/showCourseDelete/{id}")
    public String deleteEmp(@PathVariable(value = "id") long id) {
        CoursesService.DeleteCourses(id);
        return "redirect:/courses";
    }
}