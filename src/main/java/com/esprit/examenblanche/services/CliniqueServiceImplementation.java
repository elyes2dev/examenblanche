package com.esprit.examenblanche.services;

import com.esprit.examenblanche.entities.*;
import com.esprit.examenblanche.repositories.ICliniqueRepository;
import com.esprit.examenblanche.repositories.IMedecinRepository;
import com.esprit.examenblanche.repositories.IPatientRepository;
import com.esprit.examenblanche.repositories.IRendezVousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CliniqueServiceImplementation implements ICliniqueService {

    @Autowired
    private ICliniqueRepository cliniqueRepository;

    @Autowired
    private IMedecinRepository medecinRepository;

    @Autowired
    private IPatientRepository patientRepository;

    @Autowired
    private IRendezVousRepository rendezVousRepository;

    @Override
    public Clinique addClinique(Clinique clinique) {return cliniqueRepository.save(clinique);}

    @Override
    public List<Clinique> getAllCliniques() {return cliniqueRepository.findAll();}

    @Override
    public Medecin addMedecinAndAssignToClinique(Medecin medecin, Long cliniqueId) {
        Clinique clinique = cliniqueRepository.findById(cliniqueId).orElse(null);
        clinique.getMedecins().add(medecin);
        return medecinRepository.save(medecin);
    }

    @Override
    public Patient addPatient(Patient patient){
        return patientRepository.save(patient);
    }

    @Override
    public void addRDVAndAssignMedAndPatient(RendezVous rdv, Long idMedecin, Long
            idPatient){
        Medecin medecin = medecinRepository.findById(idMedecin).orElse(null);
        Patient patient = patientRepository.findById(idPatient).orElse(null);
        rdv.setMedecin(medecin);
        rdv.setPatient(patient);
        rendezVousRepository.save(rdv);
    }
    public List<RendezVous> getRendezVousByCliniqueAndSpecialite(Long
                                                                         idClinique, Speciality specialite){
        return rendezVousRepository.findByMedecinCliniquesIdCliniqueAndMedecinSpecialite(idClinique, specialite);
    }

    @Override
    public int countRDV(Long medecinId){
        return rendezVousRepository.countRendezVousByMedecin_Id(medecinId);
    }

    @Override
    @Scheduled(fixedRate = 30000)
    public void RetrieveRDV() {
        LocalDate today = LocalDate.now();
        List<RendezVous> rdvList = rendezVousRepository.findAll();
        for (RendezVous rdv : rdvList) {
            LocalDate dateToLocalDate = rdv.getDateRDV().toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
            if(dateToLocalDate.isAfter(today)){
                System.out.println("List des rendez vous" + rdv.getDateRDV() + "Medecin : " + rdv.getMedecin().getNomMedecin() + "Patient : " + rdv.getPatient().getNomPatient());
            }
        }
    }


}
