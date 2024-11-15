package com.cybernetic;

import java.util.ArrayList;

public class OrganInventory {
    private ArrayList<CyberneticOrgan> organs = new ArrayList<>();
    private int maxCapacity = 1000;

    public OrganInventory() { }

    public void addOrgan(CyberneticOrgan organ) {
        if (organs.size() < maxCapacity
            && organs.stream().noneMatch(o -> o.getId().equals(organ.getId()))) {
            organs.add(organ);
        } else {
            throw new IllegalStateException("Inventory is full");
        }
    }

    public void removeOrgan(String id, String removalReason) {
        var toRemove = organs.stream()
                .filter(o -> o.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Organ not found"));
        
        if(!toRemove.getStatus().equals("AVAILABLE")) {
            throw new IllegalStateException("Organ is not available");
        }

        organs.remove(toRemove);
        System.out.println("Organ removed: " + toRemove.getId() + " (" + removalReason + ")");
    }

    public ArrayList<CyberneticOrgan> getOrgansSortedByPowerLevel() {
        var result = new ArrayList<>(organs);
        result.sort((o1, o2) -> Integer.compare(o2.getPowerLevel(), o1.getPowerLevel()));
        return result;
    }

    public ArrayList<CyberneticOrgan> getOrgansSortedByManufacturerDate() {
        var result = new ArrayList<>(organs);
        result.sort((o1, o2) -> o2.getManufactureDate().compareTo(o1.getManufactureDate()));
        return result;
    }

    public ArrayList<CyberneticOrgan> getOrgansSortedByCompatibilityScore() {
        var result = new ArrayList<>(organs);
        result.sort((o1, o2) -> Double.compare(o2.getCompatibilityScore(), o1.getCompatibilityScore()));
        return result;
    }
}