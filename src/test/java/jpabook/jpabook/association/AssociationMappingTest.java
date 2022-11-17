package jpabook.jpabook.association;

import jpabook.jpabook.domain.Member;
import jpabook.jpabook.domain.Team;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class AssociationMappingTest {

    @PersistenceContext
    EntityManager em;


    @Test
    void testSave() {
        Team team1 = new Team("team1", "팀1");
        em.persist(team1);

        Member member1 = new Member("회원1");
        member1.setTeam(team1);
        em.persist(member1);

        Member member2 = new Member("회원2");
        member2.setTeam(team1);
        em.persist(member2);
    }
}
