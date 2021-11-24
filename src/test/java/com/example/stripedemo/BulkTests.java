package com.example.stripedemo;


import lombok.Data;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;
import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BulkTests {

    @PersistenceContext
    private EntityManager em;

    @Value("${spring.jpa.properties.hibernate.jdbc.batch_size}")
    private int batchSize;

    @Test
    public void batch사이즈() {
//        assertThat(20, is(batchSize));
//        assertThat(20, batchSize);
    }

    @Test
    @Transactional
    public void bulkInsert() {

        for (int i = 0; i < 10000; i++) {
            BulkMember member = new BulkMember();
            member.setId(i);
            member.setName("nklee");
            em.persist(member);

            if (i % batchSize == 0) {
                // Flush a batch of inserts and release memory.
                em.flush();
                em.clear();
            }
        }

        em.flush();
        em.clear();
    }
}

@Data
@Entity
@Table(name = "BULK_MEMBER")
class BulkMember {

    @Id
    private int id;

    @Lob
    private String name;

}
