package com.example.RegistryWeb.models;

import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "clinic_details")
public class ClinicDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long Id;
    @Column(name="weight")
    private int Weight;
    @Column(name="bmi")
    private String BMI;
    @Column(name="heart_rate")
    private String HeartRate;
    @Column(name="blood_type")
    private String BloodType;
    @Column(name="last_clinic_visit")
    private Date lastClinicVisit;

    @OneToOne
    @JoinColumn(name = "person_id")
    @RestResource(path = "clinic_details-person", rel="person")
    private Person person;

    public ClinicDetails(){}
    public ClinicDetails(int weight, String BMI, String heartRate, String bloodType, Date lastClinicVisit, Person person) {
        Weight = weight;
        this.BMI = BMI;
        HeartRate = heartRate;
        BloodType = bloodType;
        this.lastClinicVisit = lastClinicVisit;
        this.person = person;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public int getWeight() {
        return Weight;
    }

    public void setWeight(int weight) {
        Weight = weight;
    }

    public String getBMI() {
        return BMI;
    }

    public void setBMI(String BMI) {
        this.BMI = BMI;
    }

    public String getHeartRate() {
        return HeartRate;
    }

    public void setHeartRate(String heartRate) {
        HeartRate = heartRate;
    }

    public String getBloodType() {
        return BloodType;
    }

    public void setBloodType(String bloodType) {
        BloodType = bloodType;
    }

    public Date getLastClinicVisit() {
        return lastClinicVisit;
    }

    public void setLastClinicVisit(Date lastClinicVisit) {
        this.lastClinicVisit = lastClinicVisit;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
