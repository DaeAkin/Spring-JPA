

## Why JPA?

JPA는 도메인 모델들을 자바 클래스처럼 다룰 수 있게 만들어 줍니다. 
또한 이런 클래스 안에 동작들을 기술할 수 있기 때문에 더욱 `객체지향` 스러운 스타일을 추구 할 수 있습니다.

### 장점

- 각자 다른 데이터베이스의 맞게 DDL을 작성하지 않아도 된다.
  - DB에 종속적이지 않게 된다.(언제든지 DB 교체가능)
  - 유지보수성 ☝️
- 특정한 DB의 DML을 작성하지 않아도 된다.
- java 오브젝트 자체로 저장하거나 불러오고 그래픽 탐색을 할 수 있다.
- JPQL 사용가능

> DDL(Data Definition Language) : CREATE ALTER 같은 데이터 정의어
>
> DML(Data Manipulation Language) : SELECT INSERT 같은 데이터 조작어

### 단점

- 러닝커브가 높다.

일반적으로 JPA는  집약된 JDBC + SQL로 짜여진 코드보다 간단하고 클린합니다. 



## 목차

1. [JPA 클래스와 기본키 맵핑](https://github.com/DaeAkin/Spring-Jpa/blob/master/docs/JPA%20%ED%81%B4%EB%9E%98%EC%8A%A4%EC%99%80%20%EA%B8%B0%EB%B3%B8%ED%82%A4%20%EB%A7%B5%ED%95%91.md)
2. [JPA 필드와 컬럼 매핑](https://github.com/DaeAkin/Spring-Jpa/blob/master/docs/JPA%20%ED%95%84%EB%93%9C%EC%99%80%20%EC%BB%AC%EB%9F%BC%20%EB%A7%A4%ED%95%91.md)
3. 2
4. [@OnetoMany Mapping 주의점](https://github.com/DaeAkin/Spring-Jpa/blob/master/docs/%40OnetoMany%20Mapping%20%EC%A3%BC%EC%9D%98%EC%A0%90.md)

## DB설정

### Mysql

1. Root로 로그인 후 test 데이터베이스 생성 
2. 유저생성 **grant all privileges on test.\* to test@‘%’ identified by ‘1234‘;**



## 실행하기

test코드 실행하시면 됩니다.

