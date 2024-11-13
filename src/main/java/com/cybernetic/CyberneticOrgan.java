package com.cybernetic;

import java.time.LocalDate;

public class CyberneticOrgan {
    private String id;
    private String type;
    private String model;
    private int powerLevel;
    private double compatibilityScore;
    private LocalDate manufactureDate;
    private String status;
    private String manufacturer;

    public CyberneticOrgan(String id, String type, String model, int powerLevel, double compatibilityScore, LocalDate manufactureDate, String status, String manufacturer) {
        setId(id);
        setType(type);
        setModel(model);
        setPowerLevel(powerLevel);
        setCompatibilityScore(compatibilityScore);
        setManufactureDate(manufactureDate);
        setStatus(status);
        setManufacturer(manufacturer);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if(id.startsWith("ORG-") && id.length() == 8) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("Invalid ID format");
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        switch(type) {
            case "HEART":
            case "LUNG":
            case "KIDNEY":
            case "LIVER":
                this.type = type;
                break;

            default:
                throw new IllegalArgumentException("Invalid organ type");
        }
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if(model.length() == 11
           && (model.startsWith("HEARTX-")
           || model.startsWith("LUNGX-")
           || model.startsWith("KIDNEYX-")
           || model.startsWith("LIVERX-"))) {
            this.model = model;
        } else {
            throw new IllegalArgumentException("Invalid model");
        }
    }

    public int getPowerLevel() {
        return powerLevel;
    }

    public void setPowerLevel(int powerLevel) {
        if(powerLevel >= 1 && powerLevel <= 100) {
            this.powerLevel = powerLevel;
        } else {
            throw new IllegalArgumentException("Invalid power level");
        }
    }

    public double getCompatibilityScore() {
        return compatibilityScore;
    }

    public void setCompatibilityScore(double compatibilityScore) {
        if(compatibilityScore >= 0.0 && compatibilityScore <= 1.0) {
            this.compatibilityScore = compatibilityScore;
        } else {
            throw new IllegalArgumentException("Invalid compatibility score");
        }
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(LocalDate manufactureDate) {
        if(manufactureDate.isBefore(LocalDate.now())) {
            this.manufactureDate = manufactureDate;
        } else {
            throw new IllegalArgumentException("Invalid manufacture date");
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        switch(status) {
            case "AVAILABLE":
            case "ALLOCATED":
            case "DEFECTIVE":
                this.status = status;
                break;

            default:
                throw new IllegalArgumentException("Invalid status");
        }
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }   
}
