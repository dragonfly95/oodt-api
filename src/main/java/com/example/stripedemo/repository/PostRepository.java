package com.example.stripedemo.repository;

import com.example.stripedemo.entity.Parent;
import com.example.stripedemo.entity.Post;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    @EntityGraph(attributePaths = "comments")
    List<Post> findAll();
}
