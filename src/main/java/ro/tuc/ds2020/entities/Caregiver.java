package ro.tuc.ds2020.entities;


import java.io.Serializable;
import java.util.List;

public class Caregiver extends Person implements Serializable {


    private List<Patient> patients  = null;

    public Caregiver() {
    }

    public Caregiver(List<Patient> patients) {
        this.patients = patients;
    }

    public Caregiver(String name, String address, int age, List<Patient> patients) {
        super(name, address, age);
        this.patients = patients;
    }

    public Caregiver(String name, String address, int age, String gender, Account account, List<Patient> patients) {
        super(name, address, age, gender, account);
        this.patients = patients;
    }

    public Caregiver(String name, String address, int age, String gender, List<Patient> patients) {
        super(name, address, age, gender);
        this.patients = patients;
    }

    public Caregiver(String name, String address, int age, String gender, Account account) {
        super(name, address, age, gender, account);
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }


}
