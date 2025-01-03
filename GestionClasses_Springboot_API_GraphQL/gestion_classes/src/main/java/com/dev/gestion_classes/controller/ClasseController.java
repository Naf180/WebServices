package com.dev.gestion_classes.controller;


import com.dev.gestion_classes.model.Classe;
import com.dev.gestion_classes.repository.ClasseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class ClasseController {
    @Autowired
    private ClasseRepository classeRepository;

    @QueryMapping
    public List<Classe> getAllClasses() {
        return classeRepository.findAll();
    }

    @QueryMapping
    public Optional<Classe> getClasseById(@Argument Long id) {
        return classeRepository.findById(id);
    }

    @MutationMapping
    public Classe createClasse(@Argument String nom, @Argument Long matiereId, @Argument Long etudiantId, @Argument Long professeurId) {
        Classe classe = new Classe();
        classe.setNom(nom);
        classe.setMatiereId(matiereId);
        classe.setEtudiantId(etudiantId);
        classe.setProfesseurId(professeurId);
        return classeRepository.save(classe);
    }

    @MutationMapping
    public Classe updateClasse(@Argument Long id, @Argument String nom, @Argument Long matiereId, @Argument Long etudiantId, @Argument Long professeurId) {
        return classeRepository.findById(id)
                .map(classe -> {
                    classe.setNom(nom);
                    classe.setMatiereId(matiereId);
                    classe.setEtudiantId(etudiantId);
                    classe.setProfesseurId(professeurId);
                    return classeRepository.save(classe);
                })
                .orElseThrow(() -> new RuntimeException("Classe not found"));
    }

    @MutationMapping
    public boolean deleteClasse(@Argument Long id) {
        return classeRepository.findById(id)
                .map(classe -> {
                    classeRepository.delete(classe);
                    return true;
                })
                .orElse(false);
    }
}
