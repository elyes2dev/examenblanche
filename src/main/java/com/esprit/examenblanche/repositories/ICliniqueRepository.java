package com.esprit.examenblanche.repositories;

import com.esprit.examenblanche.entities.Clinique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICliniqueRepository extends JpaRepository<Clinique, Long> {

}