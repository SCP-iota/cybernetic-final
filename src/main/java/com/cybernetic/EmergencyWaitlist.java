package com.cybernetic;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class EmergencyWaitlist {
    private Queue<EmergencyCase> waitlist = new ArrayDeque<>();
    private Map<String, EmergencyCase> idToCase = new HashMap<>();

    public void addEmergencyCase(EmergencyCase ecase) {
        waitlist.add(ecase);
        idToCase.put(ecase.getCaseId(), ecase);
    }

    public EmergencyCase getNextUrgentCase() {
        var ecase = waitlist.poll();

        if(ecase != null) {
            idToCase.remove(ecase.getCaseId());
        }

        return ecase;
    }

    public void updateCaseSeverity(String caseId, int newLevel) {
        idToCase.get(caseId).setSeverityLevel(newLevel);
    }
}
