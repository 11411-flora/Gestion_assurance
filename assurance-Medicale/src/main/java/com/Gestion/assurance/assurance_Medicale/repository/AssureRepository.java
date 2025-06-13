package com.Gestion.assurance.assurance_Medicale.repository;


import com.Gestion.assurance.assurance_Medicale.model.enums.MethodePaiement;
import com.Gestion.assurance.assurance_Medicale.model.personne.Assure;
import com.Gestion.assurance.assurance_Medicale.model.personne.MedecinGeneraliste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface AssureRepository extends JpaRepository<Assure, Long> {

    Optional<Assure> findByNumeroAssure(String numeroAssure);
    Optional<Assure> findByEmail(String email);

    List<Assure> findByMedecinTraitant(MedecinGeneraliste medecinTraitant);
    List<Assure> findByMethodePaiementPreferee(MethodePaiement methodePaiement);

    @Query("SELECT a FROM Assure a WHERE a.nom LIKE %:nom% OR a.prenom LIKE %:prenom%")
    List<Assure> findByNomOrPrenom(@Param("nom") String nom, @Param("prenom") String prenom);

    @Query("SELECT COUNT(a) FROM Assure a WHERE a.dateInscription BETWEEN :startDate AND :endDate")
    Long countAssuresByDateInscriptionBetween(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
