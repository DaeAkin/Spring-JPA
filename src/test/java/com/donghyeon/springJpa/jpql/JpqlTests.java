package com.donghyeon.springJpa.jpql;

import com.donghyeon.springJpa.TestConfiguration;
import com.donghyeon.springJpa.global.domain.Team;
import com.donghyeon.springJpa.manytomany.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfiguration.class)
@Slf4j
public class JpqlTests {
    //Person , Ordered , Team
    @PersistenceUnit
    EntityManagerFactory emf;

    private EntityManager em;

    @Before
    public void setUp() {
        em = emf.createEntityManager(); // Retrieve an application managed entity manager
        em.getTransaction().begin();
    }

    @After
    public void finish() {
        em.getTransaction().commit();
    }

    @Test
    public void 간단한_jpql_테스트() {
        Person person = new Person("donghyeon");
        em.persist(person);
        //select person0_.person_id as person_i1_4_, person0_.username as username2_4_ from person person0_ where person0_.username='donghyeon'
        Query query = em.createQuery("select p from Person p where p.username = 'donghyeon' ");

        int i = query.getResultList().indexOf(person);

        assertThat(person).isEqualTo(query.getResultList().get(i));
    }

    @Test
    public void typeQuery_테스트() {
        Person person = new Person("donghyeon");
        em.persist(person);

        TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p where p.username = 'donghyeon' ",Person.class);
        Person result = query.getSingleResult();

        assertThat(person).isEqualTo(result);
    }

    @Test
    public void query_테스트() {
        Person person = new Person("donghyeon");
        em.persist(person);

        Query query = em.createQuery("SELECT p FROM Person p where p.username = 'donghyeon' ");
        Person result = (Person) query.getSingleResult();

        assertThat(person).isEqualTo(result);
    }

    @Test
    public void jpql_내부join_테스트() {
        Team team = new Team("토트넘");
        em.persist(team);

        Person person = new Person("donghyeon",team);
        em.persist(person);
        /**
         * select
         *      person0_.person_id as person_i1_4_,
         *      person0_.team_id as team_id3_4_,
         *      person0_.username as username2_4_
         * from
         *      person person0_ inner join team team1_ on person0_.team_id=team1_.id
         * where
         *     person0_.username='donghyeon'
         */
        //join 할때 Team이 아닌 p.team 인걸 주의!
        //inner 생략 가능
        TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p inner join p.team t where p.username = 'donghyeon' ",Person.class);
        Person result = query.getSingleResult();

        log.info(result.toString());
        assertThat(result.getUsername()).isEqualTo(person.getUsername());
    }
    @Test
    public void jpql_외부join_테스트() {
        Team team = new Team("토트넘");
        em.persist(team);

        Person person = new Person("donghyeon",team);
        em.persist(person);
        /**
         * select
         *      person0_.person_id as person_i1_4_,
         *      person0_.team_id as team_id3_4_,
         *      person0_.username as username2_4_
         * from
         *      person person0_ left outer join team team1_ on person0_.team_id=team1_.id
         * where
         *      person0_.username='donghyeon'
         */
        //outer 생략 가능
        TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p left outer join p.team t where p.username = 'donghyeon' ",Person.class);
        Person result = query.getSingleResult();

        log.info(result.toString());
        assertThat(result.getUsername()).isEqualTo(person.getUsername());
    }

    @Test
    public void jpql_컬렉션조인_테스트() {
        Team team = new Team("토트넘");
        em.persist(team);

        Person person1 = new Person("donghyeon",team);
        em.persist(person1);

        Person person2 = new Person("gildong",team);
        em.persist(person2);

        Query  query = em.createQuery("SELECT t,p FROM Team t left join t.personList p");
        List resultList = query.getResultList();

        log.info("---- resultSet start ----");
        for(Object o : resultList) {
            Object[] result = (Object[]) o;
            log.info("team : {}", result[0]); // team 객체로 가져옴
            log.info("person : {} " , result[1]); // person 객체로 가져옴
        }
        log.info("---- resultSet end ----");
    }

    @Test
    public void jpql_세타조인_테스트() {
        //세타조인은 내부조인만 지원

        Team team = new Team("토트넘");
        em.persist(team);

        Person person1 = new Person("토트넘",team);
        em.persist(person1);

        Person person2 = new Person("donghyeon",team);
        em.persist(person2);
        /**
         *  select
         *      count(person0_.person_id) as col_0_0_
         *  from
         *      person person0_
         *  cross
         *      join team team1_
         *  where
         *      person0_.username=team1_.name
         */
        Query  query = em.createQuery("select count(p) from Person p, Team t where p.username = t.name");
        List resultList = query.getResultList();
        log.info("size : {} ", resultList.size());

    }







}
