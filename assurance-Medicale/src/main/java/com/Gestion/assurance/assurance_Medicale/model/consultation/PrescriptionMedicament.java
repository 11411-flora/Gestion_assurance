package com.Gestion.assurance.assurance_Medicale.model.consultation;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("MEDICAMENT")
public class PrescriptionMedicament extends Prescription {

    private String nomMedicament;
    private String dosage;
    private Integer quantite;
    private String frequence;
    private Integer dureeTreatment; // en jours

    // Constructeurs
    public PrescriptionMedicament() {
        super();
    }

    public PrescriptionMedicament(Consultation consultation, String instructions,
                                  String nomMedicament, String dosage, Integer quantite) {
        super(consultation, instructions);
        this.nomMedicament = nomMedicament;
        this.dosage = dosage;
        this.quantite = quantite;
    }

    // Getters et setters
    public String getNomMedicament() { return nomMedicament; }
    public void setNomMedicament(String nomMedicament) { this.nomMedicament = nomMedicament; }
    public String getDosage() { return dosage; }
    public void setDosage(String dosage) { this.dosage = dosage; }
    public Integer getQuantite() { return quantite; }
    public void setQuantite(Integer quantite) { this.quantite = quantite; }
    public String getFrequence() { return frequence; }
    public void setFrequence(String frequence) { this.frequence = frequence; }
    public Integer getDureeTreatment() { return dureeTreatment; }
    public void setDureeTreatment(Integer dureeTreatment) { this.dureeTreatment = dureeTreatment; }
}
