package com.Gestion.assurance.assurance_Medicale.repository;

import com.Gestion.assurance.assurance_Medicale.model.consultation.Consultation;
import com.Gestion.assurance.assurance_Medicale.model.consultation.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
    List<Prescription> findByConsultation(Consultation consultation);
}
