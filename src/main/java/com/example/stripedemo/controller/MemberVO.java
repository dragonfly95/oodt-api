package com.example.stripedemo.controller;

import com.example.stripedemo.entity.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO {
    private long id;
    private String username;
    private String name;

    public MemberVO(MemberEntity entity) {
        this.username = entity.getUsername();
        this.name = entity.getName();
    }

    public static MemberEntity toEntity(MemberVO v) {
        return  MemberEntity.builder()
                .username(v.getUsername())
                .name(v.getName())
                .build();
    }
}
