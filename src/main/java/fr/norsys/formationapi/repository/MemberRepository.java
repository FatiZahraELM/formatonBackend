package fr.norsys.formationapi.repository;

import fr.norsys.formationapi.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member,Integer> {
    @Query(value = "SELECT m FROM FormationNote f JOIN f.member m WHERE f.member.id = :memberId")
    Member findByMemberId(@Param("memberId") Integer memberId);}
