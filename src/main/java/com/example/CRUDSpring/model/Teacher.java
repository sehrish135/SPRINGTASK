package com.example.CRUDSpring.model;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="Teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="first_name",nullable = false)
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="email")
    private String email;
    @Column(name="contact")
    private String Contact;
    //A teacher can have maximum 3 courses

    @OneToMany(targetEntity = Courses.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "tc_fk",referencedColumnName = "id")
    private List<Courses> assign;
}
