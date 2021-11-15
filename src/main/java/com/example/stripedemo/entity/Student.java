package com.example.stripedemo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    private String id;

    private String name;

    @OneToOne
    @JoinTable(name = "STUDENT_TEACHER"
    ,joinColumns = @JoinColumn(name = "STUDENT_ID")
    ,inverseJoinColumns = @JoinColumn(name = "TEACHER_ID"))
    private Teacher teacher;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
