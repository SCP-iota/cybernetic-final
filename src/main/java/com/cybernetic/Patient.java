package com.cybernetic;

import java.time.LocalDate;

public class Patient {
    private String id;
    private String name;
    private int age;
    private String bloodType;
    private String organNeeded;
    private int urgencyLevel;
    private LocalDate registrationDate;
    private String status;

    public Patient(String id, String name, int age, String bloodType, String organNeeded, int urgencyLevel, LocalDate registrationDate, String status) {
        setId(id);
        setName(name);
        setAge(age);
        setBloodType(bloodType);
        setOrganNeeded(organNeeded);
        setUrgencyLevel(urgencyLevel);
        setRegistrationDate(registrationDate);
        setStatus("WAITING");

        if(!status.equals("WAITING")) {
            throw new IllegalArgumentException("New patients must have status WAITING");
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if(id.startsWith("PAT-") && id.length() == 7) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("Invalid ID format: " + id);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age >= 1 && age <= 120) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Invalid age");
        }
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        switch(bloodType) {
            case "A+":
            case "A-":
            case "B+":
            case "B-":
            case "AB+":
            case "AB-":
            case "O+":
            case "O-":
                this.bloodType = bloodType;
                break;

            default:
                throw new IllegalArgumentException("Invalid blood type");
        }
    }

    public String getOrganNeeded() {
        return organNeeded;
    }

    public void setOrganNeeded(String organNeeded) {
        switch(organNeeded) {
            case "HEART":
            case "LUNG":
            case "KIDNEY":
            case "LIVER":
                this.organNeeded = organNeeded;
                break;

            default:
                throw new IllegalArgumentException("Invalid organ needed");
        }
    }

    public int getUrgencyLevel() {
        return urgencyLevel;
    }

    public void setUrgencyLevel(int urgencyLevel) {
        if(urgencyLevel >= 1 && urgencyLevel <= 10) {
            this.urgencyLevel = urgencyLevel;
        } else {
            throw new IllegalArgumentException("Invalid urgency level");
        }
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }
    
    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        switch(status) {
            case "WAITING":
            case "MATCHED":
            case "TRANSPLANTED":
                this.status = status;
                break;

            default:
                throw new IllegalArgumentException("Invalid status");
        }
    }
}