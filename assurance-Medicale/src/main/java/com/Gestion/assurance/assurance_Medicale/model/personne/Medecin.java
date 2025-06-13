package com.Gestion.assurance.assurance_Medicale.model.personne;

import jakarta.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "medecins")
@DiscriminatorValue("MEDECIN")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_medecin", discriminatorType = DiscriminatorType.STRING)
public abstract class Medecin extends Personne {

    @Column(unique = true, nullable = false)
    private String numeroOrdre;

    @OneToMany(mappedBy = "medecin", cascade = CascadeType.ALL)
    private List<Consultation> consultations = new ArrayList<>();

    @OneToMany(mappedBy = "medecin", cascade = CascadeType.ALL)
    private List<FeuilleDeMaladie> feuillesDeMaladie = new ArrayList<>();

    // Constructeurs
    public Medecin() {
        super();
    }

    public Medecin(String nom, String prenom, String email, String numeroOrdre) {
        super(nom, prenom, email);
        this.numeroOrdre = numeroOrdre;
    }

    // Getters et setters
    public String getNumeroOrdre() { return numeroOrdre; }
    public void setNumeroOrdre(String numeroOrdre) { this.numeroOrdre = numeroOrdre; }
    public List<Consultation> getConsultations() { return consultations; }
    public void setConsultations(List<Consultation> consultations) { this.consultations = consultations; }
    public List<FeuilleDeMaladie> getFeuillesDeMaladie() { return feuillesDeMaladie; }
    public void setFeuillesDeMaladie(List<FeuilleDeMaladie> feuillesDeMaladie) { this.feuillesDeMaladie = feuillesDeMaladie; }
}