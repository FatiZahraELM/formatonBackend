package fr.norsys.formationapi.service;

import fr.norsys.formationapi.entity.Formation;
import fr.norsys.formationapi.entity.Member;
import fr.norsys.formationapi.repository.FormationNoteRepository;
import fr.norsys.formationapi.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MemberServiceImpl implements MemberService{
    @Autowired
    private MemberRepository memberRepository;
    private final FormationNoteRepository formationNoteRepository;

    public MemberServiceImpl(FormationNoteRepository formationNoteRepository) {
        this.formationNoteRepository = formationNoteRepository;
    }

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
        member.setNotes(newMember.getNotes());
        memberRepository.save(member);
    }

    @Override
    public void deleteById(int id) {
        memberRepository.deleteById(id);
    }

    @Override
    public List<Formation> getFormationsByMemberId(int memberId) {
        return formationNoteRepository.findFormationsByMemberId(memberId);
    }
}
