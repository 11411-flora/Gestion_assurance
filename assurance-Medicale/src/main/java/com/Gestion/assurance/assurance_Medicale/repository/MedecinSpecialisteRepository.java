package com.Gestion.assurance.assurance_Medicale.repository;

import com.Gestion.assurance.assurance_Medicale.model.personne.MedecinSpecialiste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MedecinSpecialisteRepository extends JpaRepository<MedecinSpecialiste, Long> {
    List<MedecinSpecialiste> findBySpecialite(String specialite);
    List<MedecinSpecialiste> findBySpecialiteContainingIgnoreCase(String specialite);
    Optional<MedecinSpecialiste> findByNumeroOrdre(String numeroOrdre);

    @Query("SELECT DISTINCT ms.specialite FROM MedecinSpecialiste ms ORDER BY ms.specialite")
    List<String> findAllSpecialites();

    @Query("SELECT ms FROM MedecinSpecialiste ms WHERE ms.specialite = :specialite AND SIZE(ms.prescriptionsRecues) > 0")
    List<MedecinSpecialiste> findSpecialistesWithPrescriptions(@Param("specialite") String specialite);
}