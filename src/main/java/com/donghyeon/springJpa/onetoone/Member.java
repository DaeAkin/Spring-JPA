package com.donghyeon.springJpa.config.onetoone;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @OneToOne
    @JoinColumn(name="locker_id")
    Locker locker;


    public Member(String username, Locker locker) {
        this.username = username;
        this.locker = locker;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", locker=" + locker.getId() +
                '}';
    }
}
