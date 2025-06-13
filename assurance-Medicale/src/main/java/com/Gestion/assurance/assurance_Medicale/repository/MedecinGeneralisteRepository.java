package com.Gestion.assurance.assurance_Medicale.repository;

import com.Gestion.assurance.assurance_Medicale.model.personne.MedecinGeneraliste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.Date;

@Repository
public interface MedecinGeneralisteRepository extends JpaRepository<MedecinGeneraliste, Long> {
    Optional<MedecinGeneraliste> findByNumeroOrdre(String numeroOrdre);
    List<MedecinGeneraliste> findByNomContainingIgnoreCase(String nom);

    @Query("SELECT mg FROM MedecinGeneraliste mg WHERE SIZE(mg.patients) < :maxPatients")
    List<MedecinGeneraliste> findMedecinsWithLessThanPatients(@Param("maxPatients") int maxPatients);

    @Query("SELECT mg FROM MedecinGeneraliste mg JOIN mg.patients p WHERE p.id = :patientId")
    Optional<MedecinGeneraliste> findByPatientId(@Param("patientId") Long patientId);
}