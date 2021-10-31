package org.istrian;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

public class Entry implements Serializable, Comparable<Entry> {

    private final int id;
    private final EntryType type;
    private final double amount;
    private final String description;

    public Entry(int id, EntryType type, double amount, String description) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public EntryType getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public double getSignedAmount() {
        return amount * type.getMultiplier();
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int compareTo(@NotNull Entry entry) {
        return id - entry.getId();
    }

    @Override
    public String toString() {
        return "ID:\t%d; TYPE:\t%s; AMOUNT:\t%f; DESCRIPTION:\t%s".formatted(id, type, amount, description);
    }

}
