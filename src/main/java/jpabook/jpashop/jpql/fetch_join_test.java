package jpabook.jpashop.jpql;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

@Transactional
public class fetch_join_test {

        public fetch_join_test() {
        }

        public static void main(String[] args) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
            EntityManager em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            try {
                Team teamA = new Team();
                teamA.setName("팀A");
                em.persist(teamA);

                Team teamB = new Team();
                teamB.setName("팀B");
                em.persist(teamB);

                Team teamC = new Team();
                teamC.setName("팀C");
                em.persist(teamC);

                Member member1 = new Member();
                member1.setUsername("회원1");
                member1.changeTeam(teamA);
                em.persist(member1);


                Member member2 = new Member();
                member2.setUsername("회원2");
                member2.changeTeam(teamB);
                em.persist(member2);

                Member member3 = new Member();
                member3.setUsername("회원3");
                member3.changeTeam(teamC);
                em.persist(member3);
                
                
                String query = "select m from Member m join fetch m.team";

                List<Member> members = em.createQuery(query, Member.class)
                        .getResultList();

                for (Member member : members) {
                    System.out.println("members = " + member.getUsername()+
                            "teamName =" + member.getTeam().getName());
                }

            //회원1 ,팀A(SQL);// 회원 2, 팀A(1차캐시)

            } catch (Exception e){
                tx.rollback();
            } finally {
                em.close();
            }
            emf.close();
        }


    }

