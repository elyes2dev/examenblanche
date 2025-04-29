package com.esprit.examenblanche.repositories;


import com.esprit.examenblanche.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMedecinRepository extends JpaRepository<Medecin, Long> {
}
