package fr.norsys.formationapi.repository;

import fr.norsys.formationapi.entity.Formation;
import fr.norsys.formationapi.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormationRepository extends JpaRepository<Formation,Integer>{
    @Query(" FROM Member fn WHERE fn.formation.id = :formationId")
    List<Member> findMembersByFormationId(@Param("formationId") int formationId);



}
