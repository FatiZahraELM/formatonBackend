package fr.norsys.formationapi.repository;

import fr.norsys.formationapi.entity.Formation;
import fr.norsys.formationapi.entity.FormationNote;
import fr.norsys.formationapi.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional

public interface FormationNoteRepository extends JpaRepository <FormationNote,Integer> {
    @Query("SELECT fn.formation FROM FormationNote fn WHERE fn.member.member_id = :memberId")
    List<Formation> findFormationsByMemberId(@Param("memberId") int memberId);

    @Query("SELECT fn.member FROM FormationNote fn WHERE fn.formation.id = :formationId")
    List<Member> findMembersByFormationId(@Param("formationId") int formationId);

    @Query("DELETE FROM  FormationNote fn WHERE fn.formation.id = :formationId and fn.member.member_id=:memberId")
    void deleteFromNote(@Param("formationId") int formationId,@Param("memberId")int memberId);




