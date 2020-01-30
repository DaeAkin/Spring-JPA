package com.donghyeon.springJpa.manytomany;

import com.donghyeon.springJpa.onetoone.Locker;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Person {

    @Id @Column(name = "PERSON_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    /**
     * @JoinTable.name : 연결 테이블을 지정한다. 여기서는 MEMBER_PRODUCT 테이블을 선택
     * @JoinTable.joinColumns : 현재 방향인 회원과 매핑할 조인 컬럼 정보를 지정한다. MEMBER_ID로 지정.
     * @JoinTable.inverseJoinCloumns : 반대 방향인 상품과 매핑할 조인 컬럼 정보를 지정한다. PRODUCT_ID로 지정
     */
    @ManyToMany
    @JoinTable(name="PERSON_PRODUCT",
            joinColumns = @JoinColumn(name="PERSION_ID"),
            inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID"))
    private List<Product> products;
//    //TODO : LAZY Loding에 대해서 알아볼 것.
//    @OneToMany(mappedBy = "person",fetch = FetchType.EAGER)
//    private List<Ordered> orderedList;


    public Person(String username) {
        this.username = username;
    }

//    @Override
//    public String toString() {
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("Member{" +
//                "id=" + id +
//                ", username='" + username + '\'' +
//                '}');
//        for (Ordered ordered: orderedList) {
//            stringBuilder.append("product name = " + ordered.getProduct().getName());
//            stringBuilder.append("product count = " + ordered.getProductCount());
//        }
//
//       return stringBuilder.toString();
//    }
}
