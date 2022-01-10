package jpabook.jpashop.domain;

import jpabook.jpashop.mappedsuperclass.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter@Setter
public class Member extends BaseEntity {

    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_id")
    private Long id;

    private String name;
    private String city;
    private String street;
    private String zipcode;
    

    public Member() {
    }
}
