package com.cybernetic;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class TransplantRecord {
    private String operationId;
    private String patientId;
    private String organId;
    private LocalDateTime timestamp;
    private String surgeon;
    private String outcome;
    private TransplantRecord next;

    public TransplantRecord() { }

    public TransplantRecord(TransplantRecord other) {
        setOperationId(other.getOperationId());
        setPatientId(other.getPatientId());
        setOrganId(other.getOrganId());
        setTimestamp(other.getTimestamp());
        setSurgeon(other.getSurgeon());
        setOutcome(other.getOutcome());
        setNext(other.getNext());
    }

    public TransplantRecord(String operationId, String patientId, String organId,
            String surgeon, String outcome) {
        this.operationId = operationId;
        this.patientId = patientId;
        this.organId = organId;
        this.timestamp = LocalDateTime.now();
        this.surgeon = surgeon;
        this.outcome = outcome;
    }

    public void addTransplantRecordAtBeginning(TransplantRecord record) {
        setNext(new TransplantRecord(this));

        setOperationId(record.getOperationId());
        setPatientId(record.getPatientId());
        setOrganId(record.getOrganId());
        setTimestamp(record.getTimestamp());
        setSurgeon(record.getSurgeon());
        setOutcome(record.getOutcome());
    }

    public ArrayList<TransplantRecord> getRecentTransplants(int length) {
        var chunk = new ArrayList<TransplantRecord>();
        var curr = this;

        while(curr != null) {
            chunk.add(curr);

            if(chunk.size() > length) {
                chunk.remove(0);
            }

            curr = curr.getNext();
        }

        return chunk;
    }

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getOrganId() {
        return organId;
    }

    public void setOrganId(String organId) {
        this.organId = organId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getSurgeon() {
        return surgeon;
    }

    public void setSurgeon(String surgeon) {
        this.surgeon = surgeon;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public TransplantRecord getNext() {
        return next;
    }

    public void setNext(TransplantRecord next) {
        this.next = next;
    }
}
