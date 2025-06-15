package com.Gestion.assurance.assurance_Medicale.service.impl;

import com.Gestion.assurance.assurance_Medicale.model.personne.MedecinGeneraliste;
import com.Gestion.assurance.assurance_Medicale.repository.MedecinGeneralisteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedecinGeneralisteService {

    private final MedecinGeneralisteRepository repository;

    public MedecinGeneralisteService(MedecinGeneralisteRepository repository) {
        this.repository = repository;
    }

    public List<MedecinGeneraliste> trouverAvecMoinsDePatients(int max) {
        return repository.findMedecinsWithLessThanPatients(max);
    }

    public Optional<MedecinGeneraliste> trouverParPatient(Long patientId) {
        return repository.findByPatientId(patientId);
    }
}

