package ro.tuc.ds2020.entities;


import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public class Patient extends Person implements Serializable {


    private String medicalRecord = null;


    private List<MedicationPlan> medPlans  = null;

    private Caregiver caregiver  = null;



    private List<MonitoredData> MonitoredDataList;

    public Patient() {
    }

    public Patient(UUID id){
        super(id);
    }

    public Patient(String name, String address, int age, String medicalRecord) {
        super(name, address, age);
        this.medicalRecord = medicalRecord;
    }

    public Patient(String name, String address, int age, String gender, Account account, String medicalRecord) {
        super(name, address, age, gender, account);
        this.medicalRecord = medicalRecord;
    }

    public Patient(String name, String address, int age, String gender, String medicalRecord) {
        super(name, address, age, gender);
        this.medicalRecord = medicalRecord;
    }

    public Patient(String name, String address, int age, String gender, Account account, String medicalRecord, List<MedicationPlan> medPlans, Caregiver caregiver) {
        super(name, address, age, gender, account);
        this.medicalRecord = medicalRecord;
        this.medPlans = medPlans;
        this.caregiver = caregiver;
    }

    public Patient(String name, String address, int age, String gender, Account account, String medicalRecord, Caregiver caregiver) {
        super(name, address, age, gender, account);
        this.medicalRecord = medicalRecord;
        this.caregiver = caregiver;
    }

    public Patient(String name, String address, int age, String gender, Account account, String medicalRecord, List<MedicationPlan> medPlans, Caregiver caregiver, List<MonitoredData> monitoredDataList) {
        super(name, address, age, gender, account);
        this.medicalRecord = medicalRecord;
        this.medPlans = medPlans;
        this.caregiver = caregiver;
        MonitoredDataList = monitoredDataList;
    }

    public String getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(String medicalRecord) {
        this.medicalRecord = medicalRecord;
    }

    public List<MedicationPlan> getMedPlans() {
        return medPlans;
    }

    public void setMedPlans(List<MedicationPlan> medPlans) {
        this.medPlans = medPlans;
    }

    public Caregiver getCaregiver() {
        return caregiver;
    }

    public void setCaregiver(Caregiver caregiver) {
        this.caregiver = caregiver;
    }

    public List<MonitoredData> getMonitoredDataList() {
        return MonitoredDataList;
    }

    public void setMonitoredDataList(List<MonitoredData> monitoredDataList) {
        MonitoredDataList = monitoredDataList;
    }
}
