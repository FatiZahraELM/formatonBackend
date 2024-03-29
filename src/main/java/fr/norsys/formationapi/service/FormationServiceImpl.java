package fr.norsys.formationapi.service;

import fr.norsys.formationapi.entity.Formation;
import fr.norsys.formationapi.entity.Member;
import fr.norsys.formationapi.repository.FormationNoteRepository;
import fr.norsys.formationapi.repository.FormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FormationServiceImpl implements FormationService{

    @Autowired
    private FormationRepository formationRepository;
    private final FormationNoteRepository formationNoteRepository;

    public FormationServiceImpl(FormationNoteRepository formationNoteRepository) {
        this.formationNoteRepository = formationNoteRepository;
    }

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
        formation.setNotes(newFormation.getNotes());
         formationRepository.save(formation);
    }

    @Override
    public void deleteById(int id) {
        formationRepository.deleteById(id);
    }

    @Override
    public List<Member> getMembersByFormationId(int formationId) {
        return formationNoteRepository.findMembersByFormationId(formationId);
    }
    @Override
    public void deleteFromNote(int formationId, int memberId){
        formationNoteRepository.deleteFromNote(formationId,memberId);
    }
}
