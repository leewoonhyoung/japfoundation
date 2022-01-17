package jpabook.jpashop;



import jpabook.jpashop.cascade.Child;
import jpabook.jpashop.cascade.Parent;
import jpabook.jpashop.valueType.Address;
import jpabook.jpashop.valueType.Member;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Address address = new Address("city", "street", "10000");

            Member member1 = new Member();
            member1.setUsername("member1");
            member1.setHomeAddress(address);
            em.persist(member1);

            Address copyAddress = new Address(address.getCity(), address.getStreet(), address.getZipcode());

            Member member2 = new Member();
            member2.setUsername("member2");
            member2.setHomeAddress(copyAddress);
            em.persist(member2);

            member1.getHomeAddress().setCity("newCity");


        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }


}