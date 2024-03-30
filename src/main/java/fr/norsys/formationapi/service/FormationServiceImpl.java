package fr.norsys.formationapi.service;

import fr.norsys.formationapi.entity.Formation;
import fr.norsys.formationapi.entity.Member;
import fr.norsys.formationapi.repository.FormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FormationServiceImpl implements FormationService{

    @Autowired
    private FormationRepository formationRepository;



    @Override
    public List<Formation> getAll() {
        return formationRepository.findAll();
    }

    @Override
    public Formation findById(int id) {

        return formationRepository.findById(id).get();
    }

    @Override
    public void save(Formation formation) {
        formationRepository.save(formation);

    }

    @Override
    public void updateFormation(int id, Formation newFormation) {
        Formation formation=formationRepository.findById(id).get();
        formation.setTitre(newFormation.getTitre());
        formation.setDateDebut(newFormation.getDateDebut());
        formation.setDescription(newFormation.getDescription());
        formation.setDateFin(newFormation.getDateFin());
         formationRepository.save(formation);
    }

    @Override
    public void deleteById(int id) {
        formationRepository.deleteById(id);
    }

    @Override
    public List<Member> getMembersByFormationId(int formationId) {
        return formationRepository.findMembersByFormationId(formationId);
    }




}
