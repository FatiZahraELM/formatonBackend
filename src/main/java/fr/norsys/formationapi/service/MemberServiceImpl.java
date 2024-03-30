package fr.norsys.formationapi.service;

import fr.norsys.formationapi.entity.Formation;
import fr.norsys.formationapi.entity.Member;
import fr.norsys.formationapi.repository.MemberRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MemberServiceImpl implements MemberService{
    @Autowired
    private MemberRepository memberRepository;


    @Override
    public List<Member> getAll() {
        return memberRepository.findAll();
    }

    @Override
    public Member findById(int id) {
        return memberRepository.findById(id).get();
    }

    @Override
    public void save(Member member) {
        memberRepository.save(member);

    }

    @Override
    public void updateMember(int id, Member newMember) {
        Member member=memberRepository.findById(id).get();
        member.setFirstName(newMember.getFirstName());
        member.setLastName(newMember.getLastName());
        member.setEmail(newMember.getEmail());
        member.setFormation(newMember.getFormation());
        memberRepository.save(member);
    }

    @Override
    public void deleteById(int id) {
        memberRepository.deleteById(id);
    }

    @Override
    public List<Formation> getFormationByMemberId(int memberId) {
        Member member=memberRepository.findById(memberId).get();
        return memberRepository.findFormationByMemberId(member.getFormation().getId());
    }
    @Override
    @Transactional
    public void deleteMemberByFormationIdAndMemberId(int formationId, int memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new EntityNotFoundException("Member not found"));
        if (member.getFormation() != null && member.getFormation().getId() == formationId) {
            memberRepository.delete(member);
        }
    }
}
