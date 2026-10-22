package com.hemopulse.donor.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "emergency_requests")
public class EmergencyRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String bloodGroup;

    @Column(nullable = false)
    private String hospital;

    @Column(nullable = false)
    private String urgency;

    @Column(nullable = false)
    private String unitsNeeded;

    @Column(nullable = false)
    private String department;

    @Column(nullable = false)
    private String timeAgo = "Just now";

    public EmergencyRequest() {
    }

    public EmergencyRequest(Long id, String bloodGroup, String hospital, String urgency, String unitsNeeded, String department, String timeAgo) {
        this.id = id;
        this.bloodGroup = bloodGroup;
        this.hospital = hospital;
        this.urgency = urgency;
        this.unitsNeeded = unitsNeeded;
        this.department = department;
        this.timeAgo = timeAgo != null ? timeAgo : "Just now";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getUrgency() {
        return urgency;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }

    public String getUnitsNeeded() {
        return unitsNeeded;
    }

    public void setUnitsNeeded(String unitsNeeded) {
        this.unitsNeeded = unitsNeeded;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTimeAgo() {
        return timeAgo;
    }

    public void setTimeAgo(String timeAgo) {
        this.timeAgo = timeAgo;
    }
}
