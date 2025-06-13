package com.Gestion.assurance.assurance_Medicale.repository;

import com.Gestion.assurance.assurance_Medicale.model.consultation.FeuilleDeMaladie;
import com.Gestion.assurance.assurance_Medicale.model.enums.StatutRemboursement;
import com.Gestion.assurance.assurance_Medicale.model.paiement.Remboursement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface RemboursementRepository extends JpaRepository<Remboursement, Long> {

    Optional<Remboursement> findByFeuilleDeMaladie(FeuilleDeMaladie feuille);

    List<Remboursement> findByStatut(StatutRemboursement statut);
}
