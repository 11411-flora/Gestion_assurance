package com.Gestion.assurance.assurance_Medicale.repository;

import com.Gestion.assurance.assurance_Medicale.model.personne.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MedecinRepository extends JpaRepository<Medecin, Long> {
    Optional<Medecin> findByNumeroOrdre(String numeroOrdre);
    Optional<Medecin> findByEmail(String email);
    List<Medecin> findByNomContainingIgnoreCase(String nom);
}

