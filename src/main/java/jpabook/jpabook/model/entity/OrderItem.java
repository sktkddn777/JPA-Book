package jpabook.jpabook.model.entity;

import jpabook.jpabook.model.entity.item.Item;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "ORDER_ITEM")
@Data
public class OrderItem {

    @Id @GeneratedValue
    @Column(name = "ORDER_ITEM_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    private int orderPrice;
    private int count;
}
