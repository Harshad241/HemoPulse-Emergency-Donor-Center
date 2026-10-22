package com.hemopulse.donor.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "donors")
public class Donor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String bloodGroup;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String lastDonationDate;

    @Column(nullable = false)
    private Integer age = 25;

    @Column(nullable = false)
    private Boolean availability = true;

    @Column(nullable = false)
    private Integer donations = 1;

    @Column(nullable = false)
    private Double rating = 5.0;

    public Donor() {
    }

    public Donor(Long id, String fullName, String bloodGroup, String phoneNumber, String email, String city, String lastDonationDate) {
        this.id = id;
        this.fullName = fullName;
        this.bloodGroup = bloodGroup;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.city = city;
        this.lastDonationDate = lastDonationDate;
        this.age = 25;
        this.availability = true;
        this.donations = 1;
        this.rating = 5.0;
    }

    public Donor(Long id, String fullName, String bloodGroup, String phoneNumber, String email, String city, String lastDonationDate, Integer age, Boolean availability, Integer donations, Double rating) {
        this.id = id;
        this.fullName = fullName;
        this.bloodGroup = bloodGroup;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.city = city;
        this.lastDonationDate = lastDonationDate;
        this.age = age != null ? age : 25;
        this.availability = availability != null ? availability : true;
        this.donations = donations != null ? donations : 1;
        this.rating = rating != null ? rating : 5.0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLastDonationDate() {
        return lastDonationDate;
    }

    public void setLastDonationDate(String lastDonationDate) {
        this.lastDonationDate = lastDonationDate;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public Integer getDonations() {
        return donations;
    }

    public void setDonations(Integer donations) {
        this.donations = donations;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
