package com.example.stripedemo;

import com.example.stripedemo.entity.Child;
import com.example.stripedemo.entity.Parent;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@SpringBootTest
class StripeDemoApplicationTests {

	@PersistenceContext
	EntityManager entityManager;

	@Test
	@Transactional
	@Rollback(false)
	void contextLoads() {

		Parent parent = new Parent();
		parent.setName("parent");

		Child child = new Child();
		child.setName("child");

		parent.setChild(child);

		entityManager.persist(parent);
//		entityManager.persist(child);

	}

}
