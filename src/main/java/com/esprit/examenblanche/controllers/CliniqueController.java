package com.esprit.examenblanche.controllers;

import com.esprit.examenblanche.entities.*;
import com.esprit.examenblanche.services.ICliniqueService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/clinique")
public class CliniqueController {

    @Autowired
    ICliniqueService cliniqueService;

    @PostMapping("/add")
    public Clinique addClinique(@RequestBody Clinique c){
        return cliniqueService.addClinique(c);
    }

    @GetMapping("/all")
    public List<Clinique> getAllCliniques(){
        return cliniqueService.getAllCliniques();
    }

    @PostMapping("/save-medecin/{cliniqueId}")
    public Medecin saveMedecin(@PathVariable Long cliniqueId,@RequestBody Medecin medecin){
        return  cliniqueService.addMedecinAndAssignToClinique(medecin,cliniqueId);
    }

    @PostMapping("/add-patient")
    public Patient addPatient(@RequestBody Patient patient){
        return cliniqueService.addPatient(patient);
    }

    @PostMapping("/add-rdv/{idM}/{idP}")
    public void addRDVAndAssignMedAndPatient(@PathVariable Long idM, @PathVariable Long idP, @RequestBody RendezVous rdv){
        cliniqueService.addRDVAndAssignMedAndPatient(rdv,idM,idP);
    }

    @GetMapping("/getrdv/{idClinique}/{Spec}")
    public List<RendezVous> getRendezVousByCliniqueAndSpecialite(@PathVariable Long idClinique,@PathVariable Speciality Spec){
        return cliniqueService.getRendezVousByCliniqueAndSpecialite(idClinique,Spec);
    }

    @GetMapping("/count/{idMedecin}")
    public int countRDVBymedecin(@PathVariable Long idMedecin){
        return cliniqueService.countRDV(idMedecin);
    }
}
