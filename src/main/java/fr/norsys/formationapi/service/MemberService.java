package fr.norsys.formationapi.service;

import fr.norsys.formationapi.entity.Formation;
import fr.norsys.formationapi.entity.Member;
import jakarta.transaction.Transactional;

import java.util.List;

public interface MemberService {

        List<Member> getAll();
        Member findById(int id) ;

        void save(Member member);

        void updateMember(int id,Member newMember) ;


        void deleteById(int id);



        List<Formation> getFormationByMemberId(int memberId);

        @Transactional
        void deleteMemberByFormationIdAndMemberId(int formationId, int memberId);
}

