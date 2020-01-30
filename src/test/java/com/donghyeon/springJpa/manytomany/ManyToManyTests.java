package com.donghyeon.springJpa.manytomany;

import com.donghyeon.springJpa.TestConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfiguration.class)
public class ManyToManyTests {


    @Autowired
    PersonRepository personRepository;

//    @Autowired
//    OrderedRepository orderedRepository;
//
//    @Autowired
//    ProductRepository productRepository;
//
//    @Test
//    public void manyToManyTests() {
//        Person person = new Person("donghyeon");
//        Product product = new Product("Large Pizza");
//
//        person = personRepository.save(person);
//        product = productRepository.save(product);
//
//        Ordered ordered = new Ordered(person,product,3);
//
//        ordered = orderedRepository.save(ordered);
//
//        System.out.println(personRepository.findById(person.getId()).toString());
//        System.out.println(productRepository.findById(product.getId()).toString());
//        System.out.println(orderedRepository.findById(ordered.getId()).toString());
//
//
//    }
}
