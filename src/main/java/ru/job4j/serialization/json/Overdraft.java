package ru.job4j.serialization.json;

public class Overdraft {
    private final boolean overdraftEnabled;

    public Overdraft(boolean overdraftEnabled) {
        this.overdraftEnabled = overdraftEnabled;
    }

    @Override
    public String toString() {
        return "Overdraft{"
                + "overdraftEnabled="
                + overdraftEnabled
                + '}';
    }
}
