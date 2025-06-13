package com.Gestion.assurance.assurance_Medicale.repository;

import com.Gestion.assurance.assurance_Medicale.model.consultation.PrescriptionMedicament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionMedicamentRepository extends JpaRepository<PrescriptionMedicament, Long> {
    // Ajoute des méthodes spécifiques si besoin
}