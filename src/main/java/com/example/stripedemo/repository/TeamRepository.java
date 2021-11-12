package com.example.stripedemo.repository;

import com.example.stripedemo.entity.Team;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {

    @Override
//    @EntityGraph(attributePaths = "members")
    @Query("select p from Team p join fetch p.members")
    List<Team> findAll();
}
