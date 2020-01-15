

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



## DB설정

### Mysql

1. Root로 로그인 후 test 데이터베이스 생성 
2. 유저생성 **grant all privileges on test.\* to test@‘%’ identified by ‘1234‘;**



## 실행하기

test코드 실행하시면 됩니다.

