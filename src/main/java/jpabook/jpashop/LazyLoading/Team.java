package jpabook.jpashop.LazyLoading;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "team")
    List<User> user = new ArrayList<>();
}

