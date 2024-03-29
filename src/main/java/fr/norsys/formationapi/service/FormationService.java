package fr.norsys.formationapi.service;

import fr.norsys.formationapi.entity.Formation;
import fr.norsys.formationapi.entity.Member;

import java.util.List;

public interface FormationService {


    List<Formation> getAll();
    Formation findById(int id) ;

    void save(Formation formation);

    void updateFormation(int id,Formation newFormation) ;


    void deleteById(int id);



    List<Member> getMembersByFormationId(int formationId);

    void deleteFromNote(int formationId, int memberId);
}
