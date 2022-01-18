package jpabook.jpashop.jpql;

import javax.persistence.*;

@Entity
@Table(name = "ORDERS")
public class Order {

    @Id@GeneratedValue
    private Long id;
    private int orderAccount;

    @Embedded
    private Address address;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;


}
