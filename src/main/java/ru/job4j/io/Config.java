package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Config {

    private final String path;
    private final Map values = new HashMap<>();

    public Config(String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!(line.contains("#") || line.isEmpty())) {
                    String[] pair = line.split("=", 2);
                    values.put(pair[0], pair[1]);
                } else if (line.length() < 2) {
                    throw new IllegalArgumentException();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        return (String) this.values.get(key);
    }

    public static void main(String[] args) {
        Config config = new Config("data/app.properties");
        config.load();
        System.out.println(config.value("hibernate.connection.password"));
    }
}