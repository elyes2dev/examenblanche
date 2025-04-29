package com.esprit.examenblanche.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Medecin implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomMedecin;

    private Speciality speciality;

    private int telephone;

    private int prixConsultation;

    @ManyToMany(mappedBy = "medecins")
    @JsonIgnore
    private List<Clinique> cliniques;

    @OneToMany(mappedBy = "medecin")
    private List<RendezVous> rendezVousList;


}
