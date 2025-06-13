package com.Gestion.assurance.assurance_Medicale.model.consultation;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "prescriptions")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_prescription", discriminatorType = DiscriminatorType.STRING)
public abstract class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date datePrescription;

    private String instructions;

    @ManyToOne(optional = false)
    @JoinColumn(name = "consultation_id")
    private Consultation consultation;

    // Constructeurs
    public Prescription() {
        this.datePrescription = new Date();
    }

    public Prescription(Consultation consultation, String instructions) {
        this();
        this.consultation = consultation;
        this.instructions = instructions;
    }

    // Getters et setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Date getDatePrescription() { return datePrescription; }
    public void setDatePrescription(Date datePrescription) { this.datePrescription = datePrescription; }
    public String getInstructions() { return instructions; }
    public void setInstructions(String instructions) { this.instructions = instructions; }
    public Consultation getConsultation() { return consultation; }
    public void setConsultation(Consultation consultation) { this.consultation = consultation; }
}