package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LogFilter {
    private final String file;

    public LogFilter(String file) {
        this.file = file;
    }

    public List<String> filter() {
        List<String> filteredList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("data/log.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] strings = line.split(" ");
                if ("404".equals(strings[strings.length - 2])) {
                    filteredList.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filteredList;
    }

    public void saveTo(String out) {
        var data = filter();
        try (PrintWriter writer = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(out)))) {
            for (String line : data) {
                writer.printf("%s%n", line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new LogFilter("data/log.txt").saveTo("data/404.txt");
    }
}
