package com.Gestion.assurance.assurance_Medicale.repository;

import com.Gestion.assurance.assurance_Medicale.model.consultation.PrescriptionConsultation;
import com.Gestion.assurance.assurance_Medicale.model.enums.StatutPrescription;
import com.Gestion.assurance.assurance_Medicale.model.personne.MedecinGeneraliste;
import com.Gestion.assurance.assurance_Medicale.model.personne.MedecinSpecialiste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrescriptionConsultationRepository extends JpaRepository<PrescriptionConsultation, Long> {

    List<PrescriptionConsultation> findByMedecinPrescripteur(MedecinGeneraliste prescripteur);

    List<PrescriptionConsultation> findBySpecialiste(MedecinSpecialiste specialiste);

    List<PrescriptionConsultation> findByStatut(StatutPrescription statut);
}