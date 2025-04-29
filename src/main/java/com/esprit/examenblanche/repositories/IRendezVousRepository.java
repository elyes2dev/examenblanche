package com.esprit.examenblanche.repositories;

import com.esprit.examenblanche.entities.RendezVous;
import com.esprit.examenblanche.entities.Speciality;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRendezVousRepository extends JpaRepository<RendezVous, Long> {
    @Query("SELECT r FROM RendezVous r JOIN r.medecin.cliniques c WHERE c.id = :idClinique AND r.medecin.speciality = :specialite")
    List<RendezVous> findByMedecinCliniquesIdCliniqueAndMedecinSpecialite(@Param("idClinique") Long idClinique, @Param("specialite") Speciality specialite);

   // @Query("SELECT COUNT(*) FROM RendezVous r where r.medecin = :idMedecin")
    // int countByMedecin(@Param("idMedecin") Long idMedecin);

    int countRendezVousByMedecin_Id(Long medecinId);
}
