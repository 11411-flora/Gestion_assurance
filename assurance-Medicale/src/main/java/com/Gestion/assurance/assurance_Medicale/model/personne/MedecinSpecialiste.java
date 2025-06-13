package com.Gestion.assurance.assurance_Medicale.model.personne;

import jakarta.persistence.*;
import java.util.ArrayList;

@Entity
@DiscriminatorValue("SPECIALISTE")
public class MedecinSpecialiste extends Medecin {

    @Column(nullable = false)
    private String specialite;

    @OneToMany(mappedBy = "specialiste")
    private List<PrescriptionConsultation> prescriptionsRecues = new ArrayList<>();

    // Constructeurs
    public MedecinSpecialiste() {
        super();
    }

    public MedecinSpecialiste(String nom, String prenom, String email, String numeroOrdre, String specialite) {
        super(nom, prenom, email, numeroOrdre);
        this.specialite = specialite;
    }

    // Getters et setters
    public String getSpecialite() { return specialite; }
    public void setSpecialite(String specialite) { this.specialite = specialite; }
    public List<PrescriptionConsultation> getPrescriptionsRecues() { return prescriptionsRecues; }
    public void setPrescriptionsRecues(List<PrescriptionConsultation> prescriptionsRecues) { this.prescriptionsRecues = prescriptionsRecues; }
}
