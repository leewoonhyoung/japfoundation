package jpabook.jpashop.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class test_case {

        public test_case() {
        }

        public static void main(String[] args) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
            EntityManager em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            try {
                //기본 case
//                String query =
//                        "select"+
//                                "case when m.age <= 10 then '학생요금'" +
//                                "when m.age >= 60 then '경로요금'" +
//                                "else '일반요금'" +
//                        "end" +
//                                "from Member m ";
//                em.createQuery(query);


            } catch (Exception e){
                tx.rollback();
            } finally {
                em.close();
            }
            emf.close();
        }


    }

