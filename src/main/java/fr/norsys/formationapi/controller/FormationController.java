package fr.norsys.formationapi.controller;

import fr.norsys.formationapi.entity.Formation;
import fr.norsys.formationapi.entity.Member;
import fr.norsys.formationapi.service.FormationService;
import fr.norsys.formationapi.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formations")
@CrossOrigin("*")
public class FormationController {

    @Autowired
    private FormationService formationService;

    private final MemberService memberService;

    public FormationController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public ResponseEntity <List<Formation>> findAll() {
        List<Formation> formations= formationService.getAll();

        return ResponseEntity.ok().body(formations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Formation> findById(@PathVariable int id) {
        Formation formation = formationService.findById(id);

        return ResponseEntity.ok().body(formation);
    }

    @GetMapping("/{id}/members")
    public ResponseEntity<List<Member>> findMembersByFormationId(@PathVariable int id) {
        List<Member> members = formationService.getMembersByFormationId(id);

        return ResponseEntity.ok().body(members);
    }


    @PostMapping
    public ResponseEntity<Void> createFormation(@RequestBody @Valid Formation formation){

        formationService.save(formation);
        return ResponseEntity.ok(null);
    }
    @PostMapping("/{id}/members")
    public ResponseEntity<Void> addMember(@PathVariable int id,@RequestBody Member member){
        Formation formation=formationService.findById(id);
        member.setFormation(formation);
        memberService.save(member);
        return ResponseEntity.ok(null);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public  ResponseEntity<Formation> update(@PathVariable int id,@RequestBody Formation formation) {
        Formation updatedFormation=formationService.findById(id);
        updatedFormation.setTitre(formation.getTitre());
        updatedFormation.setDescription(formation.getDescription());
        updatedFormation.setDateDebut(formation.getDateDebut());
        updatedFormation.setDateFin(formation.getDateFin());

        formationService.save(updatedFormation);
        return ResponseEntity.ok(null);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){

        formationService.deleteById(id);
        return  ResponseEntity.ok(null);
    }


    @DeleteMapping("/{id1}/members/{id2}")
    public ResponseEntity<Void> deleteFromNote(@PathVariable int id1,@PathVariable int id2){
        memberService.deleteMemberByFormationIdAndMemberId(id1,id2);
        return  ResponseEntity.ok(null);
    }

}
