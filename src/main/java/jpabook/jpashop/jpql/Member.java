package jpabook.jpashop.jpql;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Member{

    @Id@GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;


    @Column(name = "NAME")
    private String username;

    private int age;

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", age=" + age +
                '}';
    }

    public void changeTeam(Team team){
        this.team = team;
        team.getMembers().add(this);
    }
}
