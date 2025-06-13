package com.Gestion.assurance.assurance_Medicale.repository;

import com.Gestion.assurance.assurance_Medicale.model.consultation.FeuilleDeMaladie;
import com.Gestion.assurance.assurance_Medicale.model.enums.StatutFeuille;
import com.Gestion.assurance.assurance_Medicale.model.personne.Assure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FeuilleDeMaladieRepository extends JpaRepository<FeuilleDeMaladie, Long> {

    Optional<FeuilleDeMaladie> findByNumeroFeuille(String numeroFeuille);

    List<FeuilleDeMaladie> findByAssure(Assure assure);

    List<FeuilleDeMaladie> findByStatut(StatutFeuille statut);
}

