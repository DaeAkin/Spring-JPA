package com.donghyeon.springJpa.criteria;

import com.donghyeon.springJpa.TestConfiguration;
import com.donghyeon.springJpa.global.domain.Human;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfiguration.class)
public class CriteriaTest {
    @PersistenceUnit
    EntityManagerFactory emf;

    @Test
    public void 간단한_서브쿼리() {


        EntityManager em = emf.createEntityManager(); // Retrieve an application managed entity manager
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Human> cq = cb.createQuery(Human.class);
        Root<Human> h = cq.from(Human.class);
        cq.select(h);
        TypedQuery<Human> query = em.createQuery(cq);
        List<Human> humans = query.getResultList();
    }
}
