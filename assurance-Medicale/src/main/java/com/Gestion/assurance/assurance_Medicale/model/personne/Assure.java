package com.Gestion.assurance.assurance_Medicale.model.personne;

import com.Gestion.assurance.assurance_Medicale.model.consultation.Consultation;
import com.Gestion.assurance.assurance_Medicale.model.consultation.FeuilleDeMaladie;
import com.Gestion.assurance.assurance_Medicale.model.enums.MethodePaiement;
import jakarta.persistence.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;


@Entity
@Table(name = "assures")
@DiscriminatorValue("ASSURE")
public class Assure extends Personne {

    @Column(unique = true, nullable = false)
    private String numeroAssure;

    @Temporal(TemporalType.DATE)
    private Date dateInscription;

    @ManyToOne
    @JoinColumn(name = "medecin_traitant_id")
    private MedecinGeneraliste medecinTraitant;

    @OneToMany(mappedBy = "assure", cascade = CascadeType.ALL)
    private List<Consultation> consultations = new ArrayList<>();

    @OneToMany(mappedBy = "assure", cascade = CascadeType.ALL)
    private List<FeuilleDeMaladie> feuillesDeMaladie = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private MethodePaiement methodePaiementPreferee;

    // Constructeurs
    public Assure() {
        super();
        this.dateInscription = new Date();
    }

    public Assure(String nom, String prenom, String email, String numeroAssure) {
        super(nom, prenom, email);
        this.numeroAssure = numeroAssure;
        this.dateInscription = new Date();
    }

    // Getters et setters
    public String getNumeroAssure() { return numeroAssure; }
    public void setNumeroAssure(String numeroAssure) { this.numeroAssure = numeroAssure; }
    public Date getDateInscription() { return dateInscription; }
    public void setDateInscription(Date dateInscription) { this.dateInscription = dateInscription; }
    public MedecinGeneraliste getMedecinTraitant() { return medecinTraitant; }
    public void setMedecinTraitant(MedecinGeneraliste medecinTraitant) { this.medecinTraitant = medecinTraitant; }
    public List<Consultation> getConsultations() { return consultations; }
    public void setConsultations(List<Consultation> consultations) { this.consultations = consultations; }
    public List<FeuilleDeMaladie> getFeuillesDeMaladie() { return feuillesDeMaladie; }
    public void setFeuillesDeMaladie(List<FeuilleDeMaladie> feuillesDeMaladie) { this.feuillesDeMaladie = feuillesDeMaladie; }
    public MethodePaiement getMethodePaiementPreferee() { return methodePaiementPreferee; }
    public void setMethodePaiementPreferee(MethodePaiement methodePaiementPreferee) { this.methodePaiementPreferee = methodePaiementPreferee; }
}

