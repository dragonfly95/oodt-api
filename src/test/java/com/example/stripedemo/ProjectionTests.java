package com.example.stripedemo;

import com.example.stripedemo.controller.ParentVO;
import com.example.stripedemo.repository.ParentRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProjectionTests {

    @Autowired
    private ParentRepository parentRepository;

    @Test
    @Transactional
    @Rollback(false)
    public void test_프로젝션() {
//        List<ParentVO> parents2 = parentRepository.findParents2();
//        parents2.forEach(p -> System.out.println("p = " + p));


        List<ParentVO> parents3 = parentRepository.findAllBy(ParentVO.class);
        parents3.forEach(p -> System.out.println("p = " + p));
    }
}
