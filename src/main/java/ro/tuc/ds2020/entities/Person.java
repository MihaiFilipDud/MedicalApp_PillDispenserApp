package ro.tuc.ds2020.entities;


import java.io.Serializable;
import java.util.UUID;


public class Person  implements Serializable{

    private static final long serialVersionUID = 1L;


    private UUID id;


    private String name;


    private String address;


    private int age;


    private String gender;



    private Account account;


    public Person() {
    }

    public Person(UUID id){
        this.id = id;
    }

    public Person(String name, String address, int age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }



    public Person(String name, String address, int age, String gender, Account account) {
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.age = age;
        this.account = account;
    }

    public Person(String name, String address, int age, String gender) {
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.age = age;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
