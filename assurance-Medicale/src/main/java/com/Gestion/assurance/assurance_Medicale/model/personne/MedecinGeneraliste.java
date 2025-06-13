package com.Gestion.assurance.assurance_Medicale.model.personne;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@DiscriminatorValue("GENERALISTE")
public class MedecinGeneraliste extends Medecin {

    @OneToMany(mappedBy = "medecinTraitant")
    private List<Assure> patients = new ArrayList<>();

    @OneToMany(mappedBy = "medecinPrescripteur")
    private List<PrescriptionConsultation> prescriptionsConsultation = new ArrayList<>();

    // Constructeurs
    public MedecinGeneraliste() {
        super();
    }

    public MedecinGeneraliste(String nom, String prenom, String email, String numeroOrdre) {
        super(nom, prenom, email, numeroOrdre);
    }

    // Getters et setters
    public List<Assure> getPatients() { return patients; }
    public void setPatients(List<Assure> patients) { this.patients = patients; }
    public List<PrescriptionConsultation> getPrescriptionsConsultation() { return prescriptionsConsultation; }
    public void setPrescriptionsConsultation(List<PrescriptionConsultation> prescriptionsConsultation) { this.prescriptionsConsultation = prescriptionsConsultation; }
}
