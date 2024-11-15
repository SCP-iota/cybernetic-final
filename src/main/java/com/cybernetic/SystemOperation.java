package com.cybernetic;

import java.time.LocalDateTime;

public class SystemOperation {
    private String operationId;
    private String operationType;
    private LocalDateTime timestamp;
    private String description;
    private boolean isReversible;

    public SystemOperation(String operationId, String operationType, String description,
            boolean isReversible) {
        this.operationId = operationId;
        this.operationType = operationType;
        this.timestamp = LocalDateTime.now();
        this.description = description;
        this.isReversible = isReversible;
    }

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        switch(operationType) {
            case "MATCH":
            case "TRANSPLANT":
            case "EMERGENCY":
                this.operationType = operationType;
                break;

            default:
                throw new IllegalArgumentException("Invalid operation type: " + operationType);
        }
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isReversible() {
        return isReversible;
    }

    public void setReversible(boolean isReversible) {
        this.isReversible = isReversible;
    }
}
