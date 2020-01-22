

## 🧐 What Is JPA?

Java 오브젝트가 데이터베이스의 테이블의 데이터를 어떻게 영속화하고, 읽고 쓸지를 표현해주는 인터페이스 입니다.

## 😧 What Is Hibernate ?

JPA **인터페이스를 구현** 한 라이브러리 중 하나가 하이버네이트 입니다.

즉 하이버네이트는 JPA 제공자 입니다. 

JPA의 핵심인 `EntityManagerFactory` , `EntityManager` , `EntityTransaction` 을 하이버 네이트에선 `SessionFactory` , `Session` ,`Transaction` 으로 상속 받고 각각 `Impl` 로 구현하고 있습니다. 

## 🤔 What is Spring Data JPA?

 Spring Data는 Spring Framework의 한 부분입니다.  **JPA 제공자가 아닙니다.** 

만약 Spring Data JPA를 사용하지 않는다면 JPA의 `EntityManager` 를 이용해서 직접 작성해야 하지만, 

Spring Data JPA는 보일러플레이트 코드를 작성해줍니다.

사용자가 `Repository` 인터페이스에 정해진 규칙대로 메소드를 입력하면 프록시가 적합한 쿼리를 날리는 구현체를 만들어 Bean으로 등록합니다. 





![](docs/img/ac.png)

## 🤔 Why JPA?

JPA는 도메인 모델들을 자바 클래스처럼 다룰 수 있게 만들어 줍니다. 
또한 이런 클래스 안에 동작들을 기술할 수 있기 때문에 더욱 `객체지향` 스러운 스타일을 추구 할 수 있습니다.

### ⚡️장점

- 각자 다른 데이터베이스의 맞게 DDL을 작성하지 않아도 된다.
  - DB에 종속적이지 않게 된다.(언제든지 DB 교체가능)
  - 유지보수성 ☝️
- 특정한 DB의 DML을 작성하지 않아도 된다.
- java 오브젝트 자체로 저장하거나 불러오고 그래픽 탐색을 할 수 있다.
- JPQL 사용가능

> DDL(Data Definition Language) : CREATE ALTER 같은 데이터 정의어
>
> DML(Data Manipulation Language) : SELECT INSERT 같은 데이터 조작어

### 👎 단점

- 러닝커브가 높다.

일반적으로 JPA는  집약된 JDBC + SQL로 짜여진 코드보다 간단하고 클린합니다. 







## ☛ 목차

1. [JPA 클래스와 기본키 맵핑](https://github.com/DaeAkin/Spring-Jpa/blob/master/docs/JPA%20%ED%81%B4%EB%9E%98%EC%8A%A4%EC%99%80%20%EA%B8%B0%EB%B3%B8%ED%82%A4%20%EB%A7%B5%ED%95%91.md)
2. [JPA 필드와 컬럼 매핑](https://github.com/DaeAkin/Spring-Jpa/blob/master/docs/JPA%20%ED%95%84%EB%93%9C%EC%99%80%20%EC%BB%AC%EB%9F%BC%20%EB%A7%A4%ED%95%91.md)
3. [JPA 연관맵핑(작성중)](https://github.com/DaeAkin/Spring-Jpa/blob/master/docs/JPA%20%EC%97%B0%EA%B4%80%EA%B4%80%EA%B3%84%20%EB%A7%A4%ED%95%91.md) 
   1. OneToOne
   2. OneToMany
   3. ManyToOne
   4. ManyToMany
4. [@OnetoMany Mapping 주의점](https://github.com/DaeAkin/Spring-Jpa/blob/master/docs/%40OnetoMany%20Mapping%20%EC%A3%BC%EC%9D%98%EC%A0%90.md)
5. JPQL
   1. QueryDSL
   2. Criteria
6. Spring DATA JPA
7. LOCK









## DB설정

### Mysql

1. Root로 로그인 후 test 데이터베이스 생성 
2. 유저생성 **grant all privileges on test.\* to test@‘%’ identified by ‘1234‘;**



## 실행하기

test코드 실행하시면 됩니다.

