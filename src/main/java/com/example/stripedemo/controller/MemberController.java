package com.example.stripedemo.controller;

import com.example.stripedemo.entity.MemberEntity;
import com.example.stripedemo.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class MemberController {

    private final MemberRepository memberRepository;

    @GetMapping("member")
    public List<MemberEntity> getMembers() {
        return memberRepository.findAll();
    }

    @PostMapping("member")
    public MemberEntity signUp(@RequestBody MemberVO memberVO) {
        MemberEntity entity = MemberVO.toEntity(memberVO);
        return memberRepository.save(entity);
    }
}