package jpabook.jpashop.valueType;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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


//    @ElementCollection
//    @CollectionTable(name = "favorite_food",
//            joinColumns = @JoinColumn(name = "member_id"))
//    @Column(name = "food_name")
//    private Set<String> favoriteFoods = new HashSet<>();


//    @ElementCollection
//    @CollectionTable(name = "address",
//    joinColumns = @JoinColumn(name = "member_id"))
//    private List<Address> addressHistory = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "member_id")
    private List<AddressEntity> addressHistory = new ArrayList<>();


    public Member() {
    }

}
