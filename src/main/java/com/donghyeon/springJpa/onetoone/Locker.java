package com.donghyeon.springJpa.config.onetoone;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Locker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(mappedBy = "locker")
    Member member;

    public Locker(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Locker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", member=" + member.getUsername() +
                '}';
    }
}
