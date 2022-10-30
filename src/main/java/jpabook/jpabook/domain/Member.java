package jpabook.jpabook.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "MEMBER")
public class Member {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "NAME")
    private String username;
    private Integer age;
}
