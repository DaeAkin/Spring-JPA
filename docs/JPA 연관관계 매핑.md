# JPA 연관관계 맵핑

JPA 연관관계 맵핑에서, JPA는 서로다른 테이블을 참조할 때 방향이라는 것이 존재합니다. 



## 예제 엔티티

사람인 Human 클래스와 사람이 속할 수 있는 팀인 Team 클래스가 있습니다.

한 팀에는 많은 사람이 속할 수 있습니다. 

사람과 팀의 관계는 **N : 1** 관계 즉 다대일 관계입니다.(사람 관점에서)

**Human**

```java
@Entity
public class Human {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int age;

    @Embedded
    private Address address;
 }
```

**Team**

```java
@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
```



## 단방향

실제 데이터베이스에서는 방향이라는 개념이 존재하지 않습니다. JPA에서만 있는 단어입니다.

Human객체에서 Team을 조회 할수는 있지만, 반대로 Team이 Human을 조회를 하지 못하는 관계를 단방향 관계라고 부릅니다.

```java
@Entity
public class Human {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int age;

    @Embedded
    private Address address;
  
    @ManyToOne
    @JoinColumn(name = "team_id")
    Team team;
 }
```

Human 입장에서는 Human 여러 명이 하나의 Team에 붙게 되므로 Human 입장에서보면 @ManyToOne이므로 어노테이션을 붙여주면 됩니다.

@JoinColumn의 역할은 fk로 team의 어떤 필드를 참조할 지 정합니다.  이 값으로 Human과 Team이 조인이 됩니다.

**ERD**

![](./img/direction1.png)



## 양방향

양방향은 단방향과 다르게, Team객체에서도 Human 들을 조회할 수 있습니다.

```java
@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "id")
    List<Human> human;
}
```

Team 입장에서는 Human과 **1:N** 관계이므로 @OneToMany 어노테이션을 적어주면 됩니다.

### FK는 누가 갖고 있어야 할까?



## @OnetoOne



## @OneToMany



## @ManyToOne



## @ManyToMany



