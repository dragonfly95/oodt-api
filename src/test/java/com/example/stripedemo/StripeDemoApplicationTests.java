package com.example.stripedemo;

import com.example.stripedemo.entity.Child;
import com.example.stripedemo.entity.Parent;
import org.junit.jupiter.api.Test;
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

	@Test
	@Transactional
	@Rollback(false)
	void contextLoads() {

//		insertFamily();

		String qlString = "select p from Parent p join p.child m";
		List<Parent> parents = entityManager
				.createQuery(qlString, Parent.class)
				.getResultList();
		for (Parent p : parents) {
			System.out.println("p = " + p);

		}
	}

	private void insertFamily() {
		Parent parent = new Parent();
		parent.setName("parent7");

		Child child = new Child();
		child.setName("child7");

//		parent.setChild(child);
		child.setParent(parent);

		entityManager.persist(parent);
	}

}
