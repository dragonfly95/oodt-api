package com.example.stripedemo;

import com.example.stripedemo.controller.ParentVO;
import com.example.stripedemo.entity.Child;
import com.example.stripedemo.entity.Parent;
import com.example.stripedemo.entity.Post;
import com.example.stripedemo.entity.PostComment;
import com.example.stripedemo.entity.Team;
import com.example.stripedemo.entity.TeamMember;
import com.example.stripedemo.repository.ParentRepository;
import com.example.stripedemo.repository.PostRepository;
import com.example.stripedemo.repository.TeamRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Tuple;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class StripeDemoApplicationTests {

	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private ParentRepository parentRepository;

	@Autowired
	private TeamRepository teamRepository;

	@Test
	@Transactional
	@Rollback(false)
	void contextLoads() {

//		insertFamily();
//
//		insertPost();

		/*
		List<Parent> parents = parentRepository.findParents();
		parents.forEach(parent -> System.out.println(parent));
		List<ParentVO> collect = parents.stream().map(ParentVO::new).collect(Collectors.toList());
		collect.forEach(parentVO -> System.out.println("parentVO = " + parentVO));
		*/

//		List<Post> posts = postRepository.findAll();
//		List<Post> posts = postRepository.findByParent_Name("pppp");
//		List<Post> posts = postRepository.findByComments_id(14L);
//		posts.forEach(post -> System.out.println("post = " + post));

//		selectTeam();
		List<Team> all = teamRepository.findAll();
		System.out.println(" 1=1 ");
	}

	private void selectTeam() {
		String qlString = "select distinct p from Team p join fetch p.members m";
		List<Team> teams = entityManager
				.createQuery(qlString, Team.class)
				.getResultList();
		for (Team p : teams) {
			System.out.println("p = " + p);

		}
	}
	private void insertTeam() {
		Team team = new Team();
		team.setName("team1");

		TeamMember member = new TeamMember();
		member.setName("member1");


		TeamMember member2 = new TeamMember();
		member2.setName("member2");

		team.addMember(member);
		team.addMember(member2);

		member.setTeam(team);
		member2.setTeam(team);

		entityManager.persist(team);
		entityManager.persist(member);
		entityManager.persist(member2);
	}

	private void insertPost() {

		PostComment postComment = new PostComment();
		postComment.setName("comment2");

		Post post = new Post();
		post.setName("post2");
		post.addPostComment(postComment);

		postComment.setPost(post);

		Post p = postRepository.save(post);
	}

	private void insertFamily() {
		Parent parent = new Parent();
		parent.setName("parent7");

		Child child = new Child();
		child.setName("child7");

		parent.setChild(child);
		child.setParent(parent);

		entityManager.persist(parent);
	}

	private void selectFamily() {
		String qlString = "select p from Parent p join p.child m";
		List<Parent> parents = entityManager
				.createQuery(qlString, Parent.class)
				.getResultList();
		for (Parent p : parents) {
			System.out.println("p = " + p);

		}
	}
}
