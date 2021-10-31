package org.istrian;

public enum EntryType {

    INCOME(1), OUTFLOW(-1);

    private final int multiplier;

    EntryType(int multiplier) {
        this.multiplier = multiplier;
    }

    public int getMultiplier() {
        return multiplier;
    }
}
