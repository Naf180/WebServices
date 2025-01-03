package com.dev.gestion_matieres.endpoint;

import com.dev.gestion_matieres.model.*;
import com.dev.gestion_matieres.repository.MatiereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class MatiereEndpoint {
    @Autowired
    private MatiereRepository matiereRepository;

    @PayloadRoot(namespace = "http://dev.com/gestion_matieres", localPart = "GetMatiereRequest")
    @ResponsePayload
    public GetMatiereResponse getMatiere(@RequestPayload GetMatiereRequest request) {
        GetMatiereResponse response = new GetMatiereResponse();
        Matiere matiere = matiereRepository.findById(request.getId()).orElse(null);
        if (matiere != null) {
            response.setMatiere(matiere);
        }
        return response;
    }

    @PayloadRoot(namespace = "http://dev.com/gestion_matieres", localPart = "CreateMatiereRequest")
    @ResponsePayload
    public CreateMatiereResponse createMatiere(@RequestPayload CreateMatiereRequest request) {
        CreateMatiereResponse response = new CreateMatiereResponse();
        Matiere matiere = new Matiere();
        matiere.setNom(request.getNom());
        matiere.setClasseId(request.getClasseId());
        matiere.setEtudiantId(request.getEtudiantId());
        matiere.setProfesseurId(request.getProfesseurId());
        matiere = matiereRepository.save(matiere);
        response.setMatiere(matiere);
        return response;
    }

    @PayloadRoot(namespace = "http://dev.com/gestion_matieres", localPart = "UpdateMatiereRequest")
    @ResponsePayload
    public UpdateMatiereResponse updateMatiere(@RequestPayload UpdateMatiereRequest request) {
        UpdateMatiereResponse response = new UpdateMatiereResponse();
        Matiere matiere = matiereRepository.findById(request.getId()).orElse(null);
        if (matiere != null) {
            matiere.setNom(request.getNom());
            matiere.setClasseId(request.getClasseId());
            matiere.setEtudiantId(request.getEtudiantId());
            matiere.setProfesseurId(request.getProfesseurId());
            matiere = matiereRepository.save(matiere);
            response.setMatiere(matiere);
        }
        return response;
    }

    @PayloadRoot(namespace = "http://dev.com/gestion_matieres", localPart = "DeleteMatiereRequest")
    @ResponsePayload
    public DeleteMatiereResponse deleteMatiere(@RequestPayload DeleteMatiereRequest request) {
        DeleteMatiereResponse response = new DeleteMatiereResponse();
        Matiere matiere = matiereRepository.findById(request.getId()).orElse(null);
        if (matiere != null) {
            matiereRepository.delete(matiere);
            response.setSuccess(true);
        }
        return response;
    }
}
