package fr.norsys.formationapi.controller;

import fr.norsys.formationapi.entity.Formation;
import fr.norsys.formationapi.entity.Member;
import fr.norsys.formationapi.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
@CrossOrigin("*")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping
    public ResponseEntity<List<Member>> findAll() {
        List<Member> members= memberService.getAll();

        return ResponseEntity.ok().body(members);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member> findById(@PathVariable int id) {
        Member member = memberService.findById(id);

        return ResponseEntity.ok().body(member);
    }
    @GetMapping("/{id}/formations")
    public ResponseEntity<List<Formation>> findFormationByMemberId(@PathVariable int id) {
        List<Formation> formation = memberService.getFormationByMemberId(id);

        return ResponseEntity.ok().body(formation);
    }


    @PostMapping
    public ResponseEntity<Void> createMember(@RequestBody @Valid Member member){

        memberService.save(member);
        return ResponseEntity.ok(null);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public  ResponseEntity<Member> update(@PathVariable int id,@RequestBody Member member) {
        Member updateMember=memberService.findById(id);
        updateMember.setFirstName(member.getFirstName());
        updateMember.setLastName(member.getLastName());
        updateMember.setEmail(member.getEmail());

        memberService.save(updateMember);
        return ResponseEntity.ok(null);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){

        memberService.deleteById(id);
        return  ResponseEntity.ok(null);
    }





}
