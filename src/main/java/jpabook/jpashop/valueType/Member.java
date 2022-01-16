package jpabook.jpashop.valueType;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Member {

    @Id@GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(name = "username")
    private String username;

    //기간 Period
    @Embedded
    private Period workPeriod;

    //주소
    @Embedded
    private Address homeAddress;


}
