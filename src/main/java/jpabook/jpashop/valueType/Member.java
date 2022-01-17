package jpabook.jpashop.valueType;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
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

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city",
                column=@Column(name = "work_city")),

            @AttributeOverride(name = "street",
                column = @Column(name = "work_street")),

            @AttributeOverride(name = "zipcode",
                column = @Column(name = "work_zipcode"))
})
    private Address workAddress;


    public Member() {
    }

}
