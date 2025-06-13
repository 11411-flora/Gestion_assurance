package com.Gestion.assurance.assurance_Medicale.model.consultation;

import com.Gestion.assurance.assurance_Medicale.model.enums.MethodePaiement;
import com.Gestion.assurance.assurance_Medicale.model.enums.StatutFeuille;
import com.Gestion.assurance.assurance_Medicale.model.paiement.Remboursement;
import com.Gestion.assurance.assurance_Medicale.model.personne.Assure;
import com.Gestion.assurance.assurance_Medicale.model.personne.Medecin;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "feuilles_maladie")
public class FeuilleDeMaladie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String numeroFeuille;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;

    @ManyToOne(optional = false)
    @JoinColumn(name = "assure_id")
    private Assure assure;

    @ManyToOne(optional = false)
    @JoinColumn(name = "medecin_id")
    private Medecin medecin;

    @OneToOne
    @JoinColumn(name = "consultation_id")
    private Consultation consultation;

    @Enumerated(EnumType.STRING)
    private MethodePaiement methodePaiement;

    @OneToOne(mappedBy = "feuilleDeMaladie", cascade = CascadeType.ALL)
    private Remboursement remboursement;

    private String observations;

    @Enumerated(EnumType.STRING)
    private StatutFeuille statut = StatutFeuille.EN_COURS;

    // Constructeurs
    public FeuilleDeMaladie() {
        this.dateCreation = new Date();
        this.numeroFeuille = generateNumeroFeuille();
    }

    public FeuilleDeMaladie(Assure assure, Medecin medecin, Consultation consultation) {
        this();
        this.assure = assure;
        this.medecin = medecin;
        this.consultation = consultation;
    }

    private String generateNumeroFeuille() {
        return "FM" + System.currentTimeMillis();
    }

    // Getters et setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNumeroFeuille() { return numeroFeuille; }
    public void setNumeroFeuille(String numeroFeuille) { this.numeroFeuille = numeroFeuille; }
    public Date getDateCreation() { return dateCreation; }
    public void setDateCreation(Date dateCreation) { this.dateCreation = dateCreation; }
    public Assure getAssure() { return assure; }
    public void setAssure(Assure assure) { this.assure = assure; }
    public Medecin getMedecin() { return medecin; }
    public void setMedecin(Medecin medecin) { this.medecin = medecin; }
    public Consultation getConsultation() { return consultation; }
    public void setConsultation(Consultation consultation) { this.consultation = consultation; }
    public MethodePaiement getMethodePaiement() { return methodePaiement; }
    public void setMethodePaiement(MethodePaiement methodePaiement) { this.methodePaiement = methodePaiement; }
    public Remboursement getRemboursement() { return remboursement; }
    public void setRemboursement(Remboursement remboursement) { this.remboursement = remboursement; }
    public String getObservations() { return observations; }
    public void setObservations(String observations) { this.observations = observations; }
    public StatutFeuille getStatut() { return statut; }
    public void setStatut(StatutFeuille statut) { this.statut = statut; }
}
