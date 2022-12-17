package jpabook.jpabook.model.entity;

import jpabook.jpabook.model.entity.status.DeliveryStatus;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Delivery extends BaseEntity{

    @Id @GeneratedValue
    @Column(name = "DELIVERY_ID")
    private Long id;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;
}
