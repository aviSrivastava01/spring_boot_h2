package com.h2.db.h2_test.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="EMPLOYEES")
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "city")
    private String city;

    @Column(name = "email")
    private String email;


}
