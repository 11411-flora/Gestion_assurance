package com.Gestion.assurance.assurance_Medicale.repository;

import com.Gestion.assurance.assurance_Medicale.model.consultation.Consultation;
import com.Gestion.assurance.assurance_Medicale.model.personne.Assure;
import com.Gestion.assurance.assurance_Medicale.model.personne.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
    List<Consultation> findByAssure(Assure assure);
    List<Consultation> findByMedecin(Medecin medecin);
    List<Consultation> findByDateConsultationBetween(Date startDate, Date endDate);

    @Query("SELECT c FROM Consultation c WHERE c.assure.id = :assureId ORDER BY c.dateConsultation DESC")
    List<Consultation> findByAssureIdOrderByDateDesc(@Param("assureId") Long assureId);

    List<Consultation> findByMotifConsultationContainingIgnoreCase(String motif);

}

