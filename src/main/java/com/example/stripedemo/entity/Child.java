package com.example.stripedemo.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Getter
@Setter
@Entity
public class Child {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @JsonIgnore
    @OneToOne
    private Parent parent;
}
