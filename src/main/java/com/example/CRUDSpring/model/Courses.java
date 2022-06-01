package com.example.CRUDSpring.model;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.apache.catalina.webresources.FileResource;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Date;

@Data
@Entity
@Table(name = "courses")
public class Courses {
    @Id
    @Column(name = "course_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long courseId;

    @Column(unique = true) // unique course code
    private String courseCode;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "description", columnDefinition = "varchar(500)")
    private String description;



}
