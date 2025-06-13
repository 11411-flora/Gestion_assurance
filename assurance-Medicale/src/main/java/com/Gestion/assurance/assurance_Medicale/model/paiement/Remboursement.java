package com.Gestion.assurance.assurance_Medicale.model.paiement;


import com.Gestion.assurance.assurance_Medicale.model.consultation.FeuilleDeMaladie;
import com.Gestion.assurance.assurance_Medicale.model.enums.MethodePaiement;
import com.Gestion.assurance.assurance_Medicale.model.enums.StatutRemboursement;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "remboursements")
public class Remboursement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false)
    @JoinColumn(name = "feuille_maladie_id")
    private FeuilleDeMaladie feuilleDeMaladie;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal montantConsultation;

    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal tauxRemboursement;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal montantRembourse;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRemboursement;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MethodePaiement methodePaiement;

    @Enumerated(EnumType.STRING)
    private StatutRemboursement statut = StatutRemboursement.EN_ATTENTE;

    private String numeroTransaction;

    // Constructeurs
    public Remboursement() {}

    public Remboursement(FeuilleDeMaladie feuilleDeMaladie, BigDecimal montantConsultation,
                         BigDecimal tauxRemboursement, MethodePaiement methodePaiement) {
        this.feuilleDeMaladie = feuilleDeMaladie;
        this.montantConsultation = montantConsultation;
        this.tauxRemboursement = tauxRemboursement;
        this.methodePaiement = methodePaiement;
        this.montantRembourse = montantConsultation.multiply(tauxRemboursement.divide(BigDecimal.valueOf(100)));
        this.dateRemboursement = new Date();
    }

    // Getters et setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public FeuilleDeMaladie getFeuilleDeMaladie() { return feuilleDeMaladie; }
    public void setFeuilleDeMaladie(FeuilleDeMaladie feuilleDeMaladie) { this.feuilleDeMaladie = feuilleDeMaladie; }
    public BigDecimal getMontantConsultation() { return montantConsultation; }
    public void setMontantConsultation(BigDecimal montantConsultation) { this.montantConsultation = montantConsultation; }
    public BigDecimal getTauxRemboursement() { return tauxRemboursement; }
    public void setTauxRemboursement(BigDecimal tauxRemboursement) { this.tauxRemboursement = tauxRemboursement; }
    public BigDecimal getMontantRembourse() { return montantRembourse; }
    public void setMontantRembourse(BigDecimal montantRembourse) { this.montantRembourse = montantRembourse; }
    public Date getDateRemboursement() { return dateRemboursement; }
    public void setDateRemboursement(Date dateRemboursement) { this.dateRemboursement = dateRemboursement; }
    public MethodePaiement getMethodePaiement() { return methodePaiement; }
    public void setMethodePaiement(MethodePaiement methodePaiement) { this.methodePaiement = methodePaiement; }
    public StatutRemboursement getStatut() { return statut; }
    public void setStatut(StatutRemboursement statut) { this.statut = statut; }
    public String getNumeroTransaction() { return numeroTransaction; }
    public void setNumeroTransaction(String numeroTransaction) { this.numeroTransaction = numeroTransaction; }
}