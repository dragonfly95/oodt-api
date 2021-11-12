package com.example.stripedemo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Team {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "team")
    private List<TeamMember> members = new ArrayList<>();

    public void addMember(TeamMember member) {
        member.setTeam(this);
        this.getMembers().add(member);
    }
}
