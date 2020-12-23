package ro.tuc.ds2020.entities;



import java.io.Serializable;


public class Doctor extends Person implements Serializable {

    public Doctor() {
    }

    public Doctor(String name, String address, int age, String gender, Account account) {
        super(name, address, age, gender, account);
    }

    public Doctor(String name, String address, int age) {
        super(name, address, age);
    }


}
