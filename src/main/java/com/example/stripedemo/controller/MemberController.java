package com.example.stripedemo.controller;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.example.stripedemo.entity.Post;
import com.example.stripedemo.repository.PostRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.stripedemo.entity.MemberEntity;
import com.example.stripedemo.entity.Parent;
import com.example.stripedemo.repository.MemberRepository;
import com.example.stripedemo.repository.ParentRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class MemberController {

    private final MemberRepository memberRepository;

    private final ParentRepository parentRepository;

    private final PostRepository postRepository;

    @GetMapping("member")
    public List<MemberEntity> getMembers() {
        return memberRepository.findAll();
    }

    @PostMapping("member")
    public MemberEntity signUp(@RequestBody MemberVO memberVO) {
        MemberEntity entity = MemberVO.toEntity(memberVO);
        return memberRepository.save(entity);
    }
    
//    @GetMapping("parent")
//    public List<ParentVO> getParent() {
//    	Stream<ParentVO> stream = parentRepository.findAll().stream().map(ParentVO::new);
//    	List<ParentVO> collect = stream.collect(Collectors.toList());
//		return collect;
//    }
    
    @GetMapping("parent")
    public List<Parent> getParent() {
    	return parentRepository.findParents();
    }

    @GetMapping("post")
    public List<Post> getPost() {
        return postRepository.findAll();
    }
}