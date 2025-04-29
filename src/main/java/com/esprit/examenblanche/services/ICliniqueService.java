package com.esprit.examenblanche.services;

import com.esprit.examenblanche.entities.*;

import java.util.List;
import java.util.Optional;

public interface ICliniqueService {
    public Clinique addClinique(Clinique clinique);
    public List<Clinique> getAllCliniques();
    public Medecin addMedecinAndAssignToClinique (Medecin medecin, Long cliniqueId);
    public Patient addPatient(Patient patient);
    public void addRDVAndAssignMedAndPatient(RendezVous rdv, Long idMedecin, Long
            idPatient);
    public List<RendezVous> getRendezVousByCliniqueAndSpecialite(Long
                                                                         idClinique, Speciality specialite);
    public int countRDV(Long medecinId);
    public void RetrieveRDV();
}
