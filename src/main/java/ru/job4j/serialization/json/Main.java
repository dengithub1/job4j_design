package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        final Account account =
                new Account(22.02, true,
                        new String[]{"RUB", "USD"},
                        new Overdraft(false));

        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(account));

        final String accontJson =
                "{"
                        + "\"balance\":100,"
                        + "\"isActive\":true,"
                        + "\"currencys\":"
                        + "[\"RUB\",\"USD\"],"
                        + "\"overdraft\":"
                        + "{"
                        + "\"overdraftEnabled\":true"
                        + "}"
                        + "}";

        final Account accountMod = gson.fromJson(accontJson, Account.class);
        System.out.println(accountMod);
    }
}
