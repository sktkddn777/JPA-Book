package jpabook.jpabook.domain.compositekey;

import javax.persistence.*;

@Entity
//@IdClass(ParentId.class)
public class Parent {

//    @Id
//    @Column(name = "PARENT_ID1")
//    private String id1;
//
//    @Id
//    @Column(name = "PARENT_ID2")
//    private String id2;

    @EmbeddedId
    private ParentId id;

    private String name;
}
