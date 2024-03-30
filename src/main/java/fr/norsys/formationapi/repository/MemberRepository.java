package fr.norsys.formationapi.repository;

import fr.norsys.formationapi.entity.Formation;
import fr.norsys.formationapi.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member,Integer> {
    @Query(value = " FROM Formation f  WHERE f.id = :id")
    List<Formation> findFormationByMemberId(@Param("id") Integer id);

}
