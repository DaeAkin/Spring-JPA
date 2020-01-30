//package com.donghyeon.springJpa.manytomany;
//
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//
//@Entity
//@Getter
//@Setter
//@NoArgsConstructor
//public class Ordered {
//
//    @Id @Column(name = "ORDERED_ID")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "PERSON_ID")
//    private Person person;
//
//    @ManyToOne
//    @JoinColumn(name="PRODUCT_ID")
//    private Product product;
//
//    private long productCount;
//
//    public Ordered(Person person, Product product, long productCount) {
//        this.person = person;
//        this.product = product;
//        this.productCount = productCount;
//    }
//
//    @Override
//    public String toString() {
//        return "Ordered{" +
//                "id=" + id +
//                ", person=" + person.getUsername() +
//                ", product=" + product.getName() +
//                ", productCount=" + productCount +
//                '}';
//    }
//}
