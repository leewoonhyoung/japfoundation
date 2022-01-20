package jpabook.jpashop;



import jpabook.jpashop.cascade.Child;
import jpabook.jpashop.cascade.Parent;
import jpabook.jpashop.jpql.Member;
import jpabook.jpashop.valueType.Address;
import jpabook.jpashop.valueType.AddressEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

public class JpaMain {

    public JpaMain() {
    }

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            //TypeQuery vs Query

            TypedQuery<Member> query = em.createQuery("select m From Member m", Member.class);
            Query query1 = em.createQuery("select m.username, m.age From Member m ");

            //embedded type 수정하는 방법.
            //            Address address = new Address("city", "street", "10000");
//
//            Member member1 = new Member();
//            member1.setUsername("member1");
//            member1.setHomeAddress(address);
//            em.persist(member1);
//
//            Address copyAddress = new Address(address.getCity(), address.getStreet(), address.getZipcode());
//
//            Member member2 = new Member();
//            member2.setUsername("member2");
//            member2.setHomeAddress(copyAddress);
//            em.persist(member2);
//
//            member1.getHomeAddress().setCity("newCity");



//            //값 타입 컬렉션 사용 예제
//
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setHomeAddress(new Address("HomeCity", "street", "10000"));
//
//            member.getFavoriteFoods().add("치킨");
//            member.getFavoriteFoods().add("족발");
//            member.getFavoriteFoods().add("피자");
//
//            member.getAddressHistory().add(new Address("old1", "street", "10000"));
//            member.getAddressHistory().add(new Address("old2", "street", "10000"));
//
//            em.persist(member);
//            em.flush();
//            em.clear();

//            // 값 타입 조회
//            Member member = new Member();
//            Member findMember = em.find(Member.class, member.getId());
//
//            List<Address> addressHistory = findMember.getAddressHistory();
//            for (Address address : addressHistory){
//                System.out.println(" addreses= " + address.getCity());
//            }
//
//            Set<String> favoriteFoods = findMember.getFavoriteFoods();
//            for (String favoriteFood: favoriteFoods){
//                System.out.println("favoriteFood = " + favoriteFood);
//            }

            //값 타입 수정
//            // homecity = > newCity
//            Member member = new Member();
//            Member findMember = em.find(Member.class, member.getId());
//            Address a = findMember.getHomeAddress();
//            findMember.setHomeAddress(new Address("newCity", a.getStreet(), a.getZipcode()));
//
//            findMember.getFavoriteFoods().remove("치킨");
//            findMember.getFavoriteFoods().add("한식");
//            findMember.getAddressHistory().remove(new AddressEntity("old1", "street", "10000"));
//            findMember.getAddressHistory().add(new AddressEntity("newCity", "street", "10000"));


//            new 방법의 프로젝션
//            Member member  = new Member();
//            member.setUsername("member1");
//            member.setAge(10);
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
//            List<Member> resultList = em.createQuery("select new jpabook.jpashop.jpql.MemberDto(m.username, m.age) from Member m", Member.class)
//                    .getResultList();
//            System.out.println("resultList = " + resultList);
//

//            pageing 예시
            for (int i = 0 ; i <100 ; i++) {
                Member member = new Member();
                member.setUsername("member1" + i);
                member.setAge(10);
                em.persist(member);
            }

            em.flush();
            em.clear();

            List<Member> resultList = em.createQuery("select m from Member m order by m.age asc", Member.class)
                    .setFirstResult(0)
                    .setMaxResults(10)
                    .getResultList();



        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }


}