package jpabook.jpabook.model.entity;

import jpabook.jpabook.model.entity.item.Item;

import javax.persistence.*;

@Entity
public class CategoryItem {

    @Id @GeneratedValue
    @Column(name = "CATEGORY_ITME_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    private Item item;

}
