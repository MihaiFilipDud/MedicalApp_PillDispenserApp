package ro.tuc.ds2020.entities;



import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.UUID;


public class MedicationPlan implements Serializable {

    private UUID id;

    private Time intakeIntervalStart;

    private Time intakeIntervalEnd;

    private Date treatmentStart;

    private Date treatmentEnd;

    private Patient patient;

    private List<Medication> medications;

    public MedicationPlan() {
    }

    public MedicationPlan(Time intakeStart, Time intakeEnd, Date treatmentStart, Date treatmentEnd, Patient patient, List<Medication> medications){
        this.intakeIntervalStart = intakeStart;
        this.intakeIntervalEnd = intakeEnd;
        this.treatmentStart = treatmentStart;
        this.treatmentEnd = treatmentEnd;
        this.patient = patient;
        this.medications = medications;
    }

    public MedicationPlan(Time intakeStart, Time intakeEnd, Date treatmentStart, Date treatmentEnd){
        this.intakeIntervalStart = intakeStart;
        this.intakeIntervalEnd = intakeEnd;
        this.treatmentStart = treatmentStart;
        this.treatmentEnd = treatmentEnd;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Time getIntakeIntervalStart() {
        return intakeIntervalStart;
    }

    public void setIntakeIntervalStart(Time intakeIntervalStart) {
        this.intakeIntervalStart = intakeIntervalStart;
    }

    public Time getIntakeIntervalEnd() {
        return intakeIntervalEnd;
    }

    public void setIntakeIntervalEnd(Time intakeIntervalEnd) {
        this.intakeIntervalEnd = intakeIntervalEnd;
    }

    public Date getTreatmentStart() {
        return treatmentStart;
    }

    public void setTreatmentStart(Date treatmentStart) {
        this.treatmentStart = treatmentStart;
    }

    public Date getTreatmentEnd() {
        return treatmentEnd;
    }

    public void setTreatmentEnd(Date treatmentEnd) {
        this.treatmentEnd = treatmentEnd;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<Medication> getMedications() {
        return medications;
    }

    public void setMedications(List<Medication> medications) {
        this.medications = medications;
    }

    @Override
    public String toString() {
        return "MedicationPlan{" +
                "id=" + id +
                ", intakeIntervalStart=" + intakeIntervalStart +
                ", intakeIntervalEnd=" + intakeIntervalEnd +
                ", treatmentStart=" + treatmentStart +
                ", treatmentEnd=" + treatmentEnd +
                ", patient=" + patient +
                ", medications=" + medications +
                '}';
    }
}
