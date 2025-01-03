package com.dev.gestion_etudiants.controller;

import com.dev.gestion_etudiants.model.Etudiant;
import com.dev.gestion_etudiants.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/etudiants")
public class EtudiantController {
    @Autowired
    private EtudiantRepository etudiantRepository;

    @GetMapping
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Etudiant> getEtudiantById(@PathVariable Long id) {
        return etudiantRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Etudiant createEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Etudiant> updateEtudiant(@PathVariable Long id, @RequestBody Etudiant etudiantDetails) {
        return etudiantRepository.findById(id)
                .map(etudiant -> {
                    etudiant.setNom(etudiantDetails.getNom());
                    etudiant.setPrenom(etudiantDetails.getPrenom());
                    etudiant.setEmail(etudiantDetails.getEmail());
                    etudiant.setClasseId(etudiantDetails.getClasseId());
                    etudiant.setMatiereId(etudiantDetails.getMatiereId());
                    etudiant.setProfesseurId(etudiantDetails.getProfesseurId());
                    Etudiant updatedEtudiant = etudiantRepository.save(etudiant);
                    return ResponseEntity.ok(updatedEtudiant);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEtudiant(@PathVariable Long id) {
        return etudiantRepository.findById(id)
                .map(etudiant -> {
                    etudiantRepository.delete(etudiant);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
