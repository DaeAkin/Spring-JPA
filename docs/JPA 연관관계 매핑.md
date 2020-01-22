# JPA 연관관계 맵핑(작성중)

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

    @OneToMany(mappedBy = "team")
    List<Human> human;
}
```

Team 입장에서는 Human과 **1:N** 관계이므로 @OneToMany 어노테이션을 적어주면 됩니다.

### 연관관계의 주인

@OneToMAny는 이해가 한 번에 되지만, mappedBy속성은 왜 필요할까요?

실제로는 객체에는 양방향 연관관계라는 것은 없습니다. 서로 다른 단방향 연관관계 2개를 로직으로 잘 묶어서 양방향으로 보이게 할 뿐입니다.

반면에 데이터베이스 테이블은 외래 키 하나로 양쪽이 서로 조인할 수 있습니다.

그럼 왜 mappedBy 속성이 필요할까요?

양방향 연관관계는 단방향 연관관계가 X 2개 있는 것과 동일하기 때문에 이 연관관계 외래키를 관리하는 포인트가 2군데로 늘어 나게 됩니다. 

그래서 한쪽에 두고 사용해야 하기 때문에 **두 연관관계 중 하나를 정해서 테이블의 외래키를 관리**해야 하는데, 이것을 연관관계 주인이라고 합니다.

연관관계 **주인만이 데이터베이스 연관관계와 매핑되고, 외래키를 관리(등록,수정,삭제**)할 수 있습니다. 반면에 주인이 아닌 쪽은 **읽기**만 할 수 있습니다.

- 연관관계 주인은 mappedBy 속성을 사용하지 않는다.
- 주인이 아니면 mappedBy 속성을 사용해서 속성의 값으로 연관관계의 주인을 지정해야한다.



### 연관관계 주인 선택

연관관계의 주인을 정한다는 것은 사실 외래 키 관리자를 선택하는 것입니다.

#### 누가 연관관계 주인이 될래?







## @OnetoOne



## @OneToMany



## @ManyToOne



## @ManyToMany



