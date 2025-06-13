package com.Gestion.assurance.assurance_Medicale.model.consultation;

import java.math.BigDecimal;
import java.util.*;

import com.Gestion.assurance.assurance_Medicale.model.personne.Assure;
import com.Gestion.assurance.assurance_Medicale.model.personne.Medecin;
import jakarta.persistence.*;

@Entity
@Table(name = "consultations")
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dateConsultation;

    private String motifConsultation;
    private String diagnostic;
    private String observations;

    @Column(nullable = false)
    private BigDecimal tarif;

    @ManyToOne(optional = false)
    @JoinColumn(name = "assure_id")
    private Assure assure;

    @ManyToOne(optional = false)
    @JoinColumn(name = "medecin_id")
    private Medecin medecin;

    @OneToMany(mappedBy = "consultation", cascade = CascadeType.ALL)
    private List<Prescription> prescriptions = new ArrayList<>();

    // Constructeurs
    public Consultation() {}

    public Consultation(Date dateConsultation, Assure assure, Medecin medecin, BigDecimal tarif) {
        this.dateConsultation = dateConsultation;
        this.assure = assure;
        this.medecin = medecin;
        this.tarif = tarif;
    }

    // Getters et setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Date getDateConsultation() { return dateConsultation; }
    public void setDateConsultation(Date dateConsultation) { this.dateConsultation = dateConsultation; }
    public String getMotifConsultation() { return motifConsultation; }
    public void setMotifConsultation(String motifConsultation) { this.motifConsultation = motifConsultation; }
    public String getDiagnostic() { return diagnostic; }
    public void setDiagnostic(String diagnostic) { this.diagnostic = diagnostic; }
    public String getObservations() { return observations; }
    public void setObservations(String observations) { this.observations = observations; }
    public BigDecimal getTarif() { return tarif; }
    public void setTarif(BigDecimal tarif) { this.tarif = tarif; }
    public Assure getAssure() { return assure; }
    public void setAssure(Assure assure) { this.assure = assure; }
    public Medecin getMedecin() { return medecin; }
    public void setMedecin(Medecin medecin) { this.medecin = medecin; }
    public List<Prescription> getPrescriptions() { return prescriptions; }
    public void setPrescriptions(List<Prescription> prescriptions) { this.prescriptions = prescriptions; }
}
