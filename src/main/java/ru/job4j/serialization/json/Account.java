package ru.job4j.serialization.json;

import java.util.Arrays;

public class Account {
    private final double balance;
    private final boolean isActve;
    private final String[] currencys;
    private final Overdraft overdraft;

    public Account(double balance, boolean isActve, String[] currencys, Overdraft overdraft) {
        this.balance = balance;
        this.isActve = isActve;
        this.currencys = currencys;
        this.overdraft = overdraft;
    }

    @Override
    public String toString() {
        return "Account{"
                + "balance=" + balance
                + ", isActve=" + isActve
                + ", currencys=" + Arrays.toString(currencys)
                + ", overdraft=" + overdraft
                + '}';
    }
}
