package jpabook.jpabook.persistence;

import jpabook.jpabook.domain.Member;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

/**
 * 예제 3.13 테스트
 *
 */
@SpringBootTest
public class JunPersistenceTest {

    @PersistenceUnit
    EntityManagerFactory factory;


    @Test
    void 준영속_병합() {
        Member member = createMember("memberA");
        // 준영속 상태로 됨
        member.setUsername("memberB");
        mergeMember(member);
    }

    Member createMember(String username) {
        EntityManager em1 = factory.createEntityManager();
        EntityTransaction tx1 = em1.getTransaction();
        tx1.begin();

        Member member = new Member();
        member.setUsername(username);

        em1.persist(member);
        tx1.commit();

        em1.close();
        return member;
    }

    void mergeMember(Member member) {
        EntityManager em2 = factory.createEntityManager();
        EntityTransaction tx2 = em2.getTransaction();

        tx2.begin();
        Member mergeMember = em2.merge(member);

        tx2.commit();

        System.out.println("준영속 상태 member = " + member.getUsername());
        System.out.println("영속 상태 member = " + mergeMember.getUsername());

        System.out.println("em2 contains member = " + em2.contains(member));
        System.out.println("em2 contains mergeMember = " + em2.contains(mergeMember));

        em2.close();
    }
}
