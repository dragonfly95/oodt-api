package com.example.stripedemo.controller;

import com.example.stripedemo.entity.MemberEntity;
import com.example.stripedemo.repository.MemberRepository;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class MemberController {

    private final MemberRepository memberRepository;

    @GetMapping("member")
    public List<MemberEntity> getMembers() {
        return memberRepository.findAll();
    }

    @PostMapping("member")
    public MemberEntity signUp() {
        final MemberEntity member = MemberEntity.builder()
                .username("Test@gmail.com")
                .name("Test")
                .build();
        return memberRepository.save(member);
    }
}