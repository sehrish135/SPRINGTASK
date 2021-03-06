package com.example.CRUDSpring.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="Student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="first_name",nullable = false)
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="email")
    private String email;
}
