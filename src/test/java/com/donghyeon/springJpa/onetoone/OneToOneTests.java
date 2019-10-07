package com.donghyeon.springJpa.onetoone;

import com.donghyeon.springJpa.TestConfiguration;
import com.donghyeon.springJpa.config.onetoone.Locker;
import com.donghyeon.springJpa.config.onetoone.LockerRepository;
import com.donghyeon.springJpa.config.onetoone.Member;
import com.donghyeon.springJpa.config.onetoone.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfiguration.class)
public class OneToOneTests {
    @Autowired
    MemberRepository memberRepository;

    @Autowired
    LockerRepository lockerRepository;

    @Test
    public void OnetoOneTests() {
        Locker locker = new Locker("first Locker");
        Member member = new Member("donghyeon",locker);

        locker = lockerRepository.save(locker);
        member = memberRepository.save(member);

        locker = lockerRepository.findById(locker.getId()).get();
        member = memberRepository.findById(member.getId()).get();

        System.out.println(locker.toString());
        System.out.println(member.toString());
    }
}
