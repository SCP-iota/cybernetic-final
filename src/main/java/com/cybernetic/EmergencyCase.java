package com.cybernetic;

import java.time.LocalDateTime;

public class EmergencyCase {
    private String caseId;
    private Patient patient;
    private int severityLevel;
    private LocalDateTime registrationTime;

    public EmergencyCase(String caseId, Patient patient, int severityLevel, LocalDateTime registrationTime) {
        this.caseId = caseId;
        this.patient = patient;
        this.severityLevel = severityLevel;
        this.registrationTime = registrationTime;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }
    
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    
    public int getSeverityLevel() {
        return severityLevel;
    }

    public void setSeverityLevel(int severityLevel) {
        this.severityLevel = severityLevel;
    }

    public LocalDateTime getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(LocalDateTime registrationTime) {
        this.registrationTime = registrationTime;
    }
}
