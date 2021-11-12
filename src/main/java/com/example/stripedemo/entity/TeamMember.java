package com.example.stripedemo.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
@Getter
@Setter
public class TeamMember {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Team team;

    public void setTeam(Team team) {
        this.team = team;
        this.team.getMembers().add(this);
    }
}
