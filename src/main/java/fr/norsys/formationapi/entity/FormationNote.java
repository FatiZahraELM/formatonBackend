package fr.norsys.formationapi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class FormationNote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "formation_id")
    private Formation formation;

    private int note;

}
