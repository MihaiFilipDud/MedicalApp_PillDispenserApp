package ro.tuc.ds2020.entities;


import java.io.Serializable;
import java.util.Date;
import java.util.UUID;


public class MedicationStatus implements Serializable {

    private UUID id;


    private Date administeredTime;


    private Boolean isTaken;

    private Medication medication;

    public MedicationStatus() {
    }

    public MedicationStatus(Date administeredTime, Boolean isTaken, Medication medication) {
        this.administeredTime = administeredTime;
        this.isTaken = isTaken;
        this.medication = medication;
    }

    public MedicationStatus(UUID id, Date administeredTime, Boolean isTaken, Medication medication) {
        this.id = id;
        this.administeredTime = administeredTime;
        this.isTaken = isTaken;
        this.medication = medication;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getAdministeredTime() {
        return administeredTime;
    }

    public void setAdministeredTime(Date administeredTime) {
        this.administeredTime = administeredTime;
    }

    public Boolean getTaken() {
        return isTaken;
    }

    public void setTaken(Boolean taken) {
        isTaken = taken;
    }

    public Medication getMedication() {
        return medication;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }
}
