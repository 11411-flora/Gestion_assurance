package com.Gestion.assurance.assurance_Medicale.model.consultation;


import com.Gestion.assurance.assurance_Medicale.model.enums.StatutPrescription;
import com.Gestion.assurance.assurance_Medicale.model.personne.MedecinGeneraliste;
import com.Gestion.assurance.assurance_Medicale.model.personne.MedecinSpecialiste;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("CONSULTATION")
public class PrescriptionConsultation extends Prescription {

    @ManyToOne(optional = false)
    @JoinColumn(name = "medecin_prescripteur_id")
    private MedecinGeneraliste medecinPrescripteur;

    @ManyToOne(optional = false)
    @JoinColumn(name = "specialiste_id")
    private MedecinSpecialiste specialiste;

    private String motifConsultation;
    private boolean urgent = false;

    @Enumerated(EnumType.STRING)
    private StatutPrescription statut = StatutPrescription.EN_ATTENTE;

    // Constructeurs
    public PrescriptionConsultation() {
        super();
    }

    public PrescriptionConsultation(Consultation consultation, String instructions,
                                    MedecinGeneraliste medecinPrescripteur, MedecinSpecialiste specialiste, String motifConsultation) {
        super(consultation, instructions);
        this.medecinPrescripteur = medecinPrescripteur;
        this.specialiste = specialiste;
        this.motifConsultation = motifConsultation;
    }

    // Getters et setters
    public MedecinGeneraliste getMedecinPrescripteur() { return medecinPrescripteur; }
    public void setMedecinPrescripteur(MedecinGeneraliste medecinPrescripteur) { this.medecinPrescripteur = medecinPrescripteur; }
    public MedecinSpecialiste getSpecialiste() { return specialiste; }
    public void setSpecialiste(MedecinSpecialiste specialiste) { this.specialiste = specialiste; }
    public String getMotifConsultation() { return motifConsultation; }
    public void setMotifConsultation(String motifConsultation) { this.motifConsultation = motifConsultation; }
    public boolean isUrgent() { return urgent; }
    public void setUrgent(boolean urgent) { this.urgent = urgent; }
    public StatutPrescription getStatut() { return statut; }
    public void setStatut(StatutPrescription statut) { this.statut = statut; }
}

