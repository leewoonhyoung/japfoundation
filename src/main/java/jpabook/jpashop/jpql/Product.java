package jpabook.jpashop.jpql;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {

    @Id@GeneratedValue
    private Long id;
    private String name;
    private int price;
    private int stockAccount;

    @OneToMany(mappedBy = "product")
    private List<Order> orders = new ArrayList<>();

}
