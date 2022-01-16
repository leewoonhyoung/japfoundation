package jpabook.jpashop.LazyLoading;

import javax.persistence.*;

@Entity
public class User {
    @Id @GeneratedValue
    private Long id;

    @Column(name = "username")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;
}

