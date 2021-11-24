package com.example.stripedemo.repository;

import com.example.stripedemo.controller.ParentVO;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.stripedemo.entity.Parent;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ParentRepository extends JpaRepository<Parent, Long>{

    @Query("select p from Parent p join fetch p.child")
    List<Parent> findParents();

    @Query("select p from Parent p join fetch p.child")
    List<ParentVO> findParents2();

    @EntityGraph(attributePaths = "child")
    <T>List<T> findAllBy(Class<T> cls);

}
