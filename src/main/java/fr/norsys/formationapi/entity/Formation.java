package fr.norsys.formationapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="formations")
@Data

public class Formation {

    @Id
    @Column(name = "formation_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "titre")
    private String titre;

    @Column(name = "description")
    private String description;

    @Column(name="dateDebut")
    private LocalDateTime dateDebut;

    @Column(name="dateFin")
    private LocalDateTime dateFin;
    @JsonIgnore
    @OneToMany(mappedBy = "formation")
    private List<FormationNote> notes;
}
