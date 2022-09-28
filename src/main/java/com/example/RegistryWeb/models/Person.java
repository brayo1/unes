package com.example.RegistryWeb.models;

import javax.persistence.*;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastname;
    @Column(name="sex")
    private String  sex;
    @Column(name="nationality")
    private String  nationality;
    @Column(name="occupation")
    private String occupation;
    @Column(name="religion")
    private String religion;
    @Column(name="email")
    private String email;
    @Column(name="address")
    private String address;
    @Column(name="age")
    private int age;
    @Column(name="phone")
    private String phone;

    @OneToOne(mappedBy = "person", cascade=CascadeType.ALL)
    private ClinicDetails clinicDetails;

    @OneToOne(mappedBy = "person", cascade=CascadeType.ALL)
    private NextOfKin nextOfKin;



    public Person(){}
    public Person(String firstName, String lastname, String sex, String nationality, String occupation, String religion, String email, String address, int age, String phone, ClinicDetails clinicDetails, NextOfKin nextOfKin) {
        this.firstName = firstName;
        this.lastname = lastname;
        this.sex = sex;
        this.nationality = nationality;
        this.occupation = occupation;
        this.religion = religion;
        this.email = email;
        this.address = address;
        this.age = age;
        this.phone = phone;
        this.clinicDetails = clinicDetails;
        this.nextOfKin = nextOfKin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ClinicDetails getClinicDetails() {
        return clinicDetails;
    }

    public void setClinicDetails(ClinicDetails clinicDetails) {
        this.clinicDetails = clinicDetails;
    }

    public NextOfKin getNextOfKin() {
        return nextOfKin;
    }

    public void setNextOfKin(NextOfKin nextOfKin) {
        this.nextOfKin = nextOfKin;
    }
}
