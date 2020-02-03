package com.donghyeon.springJpa.jpql.criteria;

import com.donghyeon.springJpa.TestConfiguration;


import com.donghyeon.springJpa.global.domain.Team;
import com.donghyeon.springJpa.global.domain.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.*;
import javax.persistence.criteria.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfiguration.class)
public class CriteriaTests {

    @PersistenceUnit
    EntityManagerFactory emf;

    private EntityManager em;

    Person donghyeon;
    Person son;
    Person someone;

    @Before
    public void setUp() {
        em = emf.createEntityManager(); // Retrieve an application managed entity manager
        em.getTransaction().begin();
        em.createQuery("delete from Person").executeUpdate();
        em.createQuery("delete from Team ").executeUpdate();

        Team team1 = new Team("토트넘");
        em.persist(team1);
        Team team2 = new Team("맨시티");
        em.persist(team2);

        Person donghyeon = new Person("donghyeon", 25, team1);
        Person son = new Person("son", 27, team1);
        Person someone = new Person("someone", 21, team2);
        em.persist(donghyeon);
        em.persist(son);
        em.persist(someone);
    }

    @After
    public void finish() {

        em.getTransaction().commit();
    }

    @Test
    public void 간단한_criteria_테스트() {
        Person person = new Person("donghyeon");
        em.persist(person);

        //select p from Person p where p.username = 'donghyeon' -> Criteria로 변경

        //Criteria 사용 준비
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Person> query = cb.createQuery(Person.class);

        //루트 클래스(조회를 시작할 클래스)
        Root<Person> m = query.from(Person.class);

        // 쿼리 생성
        CriteriaQuery<Person> cq = query.select(m).where(cb.equal(m.get("username"), "donghyeon"));
        List<Person> resultList = em.createQuery(cq).getResultList();

        assertThat(resultList.get(0)).isEqualTo(person);
    }

    @Test
    public void SELECT_테스트() {
        CriteriaBuilder cb = em.getCriteriaBuilder(); // 쿼리 빌더

        //Criteria 생성, 반환 타입 지정
        CriteriaQuery<Person> cq = cb.createQuery(Person.class);

        Root<Person> m = cq.from(Person.class); // FROM 절
        cq.select(m); // SELECT 절

        TypedQuery<Person> query = em.createQuery(cq);
        List<Person> personList = query.getResultList();

        log.info("members : {}", personList.get(0).getUsername());
        log.info("members : {}", personList.get(0).getTeam().getName());
    }

    @Test
    public void 검색_조건_테스트() {
        //select p from Person p
        //where p.username='donghyeon'
        //order by p.age desc
        CriteriaBuilder cb = em.getCriteriaBuilder(); // 쿼리 빌더
        CriteriaQuery<Person> cq = cb.createQuery(Person.class);
        Root<Person> p = cq.from(Person.class); // FROM절 생성
        //검색 조건 정의
        Predicate usernameEqual = cb.equal(p.get("username"), "donghyeon");
        //정렬 조건 정의
        Order ageDesc = cb.desc(p.get("age"));
        //쿼리 생성
        cq.select(p)
                .where(usernameEqual)//WHERE 절 생성
                .orderBy(ageDesc);

        List<Person> resultList = em.createQuery(cq).getResultList();

        assertThat(resultList.get(0).getUsername()).isEqualTo(donghyeon.getUsername());
        //왜 안돼지 이거ㅋ
    }

    @Test
    public void 스물두살_초과하는_회원_조회_테스트() {
        //select p from Person p
        //where p.age > 22
        CriteriaBuilder cb = em.getCriteriaBuilder(); // 쿼리 빌더
        CriteriaQuery<Person> cq = cb.createQuery(Person.class);
        Root<Person> p = cq.from(Person.class); // FROM절 생성
        //검색 조건 정의
        Predicate ageGt = cb.greaterThan(p.<Integer>get("age"), 22);

        //쿼리 생성
        cq.select(p)
                .where(ageGt);//WHERE 절 생성

        List<Person> resultList = em.createQuery(cq).getResultList();

        log.info(resultList.toString());
        assertThat(resultList.size()).isEqualTo(2);
    }

    @Test
    public void 튜플_테스트() {
        CriteriaBuilder cb = em.getCriteriaBuilder(); // 쿼리 빌더
        CriteriaQuery<Tuple> cq = cb.createQuery(Tuple.class);
        Root<Person> p = cq.from(Person.class); // FROM절 생성

        //쿼리 생성
        cq.multiselect(
                p.get("username").alias("username"), // 튜플에서 사용할 튜플 별칭
                p.get("age").alias("age")
        );

        TypedQuery<Tuple> query = em.createQuery(cq);
        List<Tuple> resultList = query.getResultList();
        for (Tuple tuple: resultList) {
            //튜플 별칭으로 조회
            String username = tuple.get("username",String.class);
            log.info("username : {}" , username);
        }
    }

    @Test
    public void GROUP_BY_테스트() {
        CriteriaBuilder cb = em.getCriteriaBuilder(); // 쿼리 빌더
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
        Root<Person> p = cq.from(Person.class); // FROM절 생성

        Expression<Integer> maxAge = cb.max(p.get("age"));
        Expression<Integer> minAge = cb.min(p.get("age"));

        cq.multiselect(p.get("team").get("name"),maxAge, minAge);
        cq.groupBy(p.get("team").get("name")); // GROUP BY

        /** 팀 이름별로 나이가 가장 많은 사람과 가장 적은 사람을 구하기
         * select
         *      team1_.name as col_0_0_,
         *      max(person0_.age) as col_1_0_,
         *      min(person0_.age) as col_2_0_
         * from
         *      person person0_
         * cross join
         *      team team1_
         * where
         *      person0_.team_id=team1_.id
         * group by
         *      team1_.name
         */
        TypedQuery<Object[]> query =  em.createQuery(cq);
        List<Object[]> resultList = query.getResultList();

        log.info("result : {}" , resultList.toString());
    }

    @Test
    public void HAVING_테스트() {
        //GROUP BY 테스트에서 가장 나이 어린 사람이 20살을 초과하는 팀을 조회
        CriteriaBuilder cb = em.getCriteriaBuilder(); // 쿼리 빌더
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
        Root<Person> p = cq.from(Person.class); // FROM절 생성

        Expression<Integer> maxAge = cb.max(p.get("age"));
        Expression<Integer> minAge = cb.min(p.get("age"));

        cq.multiselect(p.get("team").get("name"),maxAge, minAge)
           .groupBy(p.get("team").get("name")) // GROUP BY
            .having(cb.gt(minAge,20)); //HAVING

        TypedQuery<Object[]> query =  em.createQuery(cq);
        List<Object[]> resultList = query.getResultList();

        log.info("result : {}" , resultList.toString());
    }

    @Test
    public void JOIN_테스트() {
        // INNER 내부조인
        // LEFT 왼쪽 외부 조인
        // RIGHT 오른쪽 외부 조인
        // JPA 구현체나 데이터베이스에 따라 지원하지 않을 수 있음.

        CriteriaBuilder cb = em.getCriteriaBuilder(); // 쿼리 빌더
        CriteriaQuery<Object> cq = cb.createQuery(Object.class);
        Root<Person> p = cq.from(Person.class); // FROM절 생성
        Join<Person,Team> t = p.join("team",JoinType.INNER);

        cq.multiselect(p,t)
                .where(cb.equal(t.get("name"),"토트넘"));
        TypedQuery<Object> query = em.createQuery(cq);
        List<Object> resultList = query.getResultList();

        log.info(resultList.toString());
        for(Object o : resultList) {
            Object[] result = (Object[]) o;
            log.info("Person : {}", result[0]); // team 객체로 가져옴
            log.info("Team : {} " , result[1]); // person 객체로 가져옴
        }
//        Team team = (Team) resultList.get(1);
//
//        log.info(team.toString());


    }

}