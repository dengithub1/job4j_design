package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Analysis {

    public void unavailable(String source, String target) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             PrintWriter writer = new PrintWriter(target)) {
            String line;
            boolean isUnavailable = false;
            String startTime = null;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                String status = parts[0];
                String time = parts[1];
                if (("400".equals(status) || "500".equals(status) && !isUnavailable)) {
                    startTime = time;
                    isUnavailable = true;
                } else if (isUnavailable) {
                    if (!("400".equals(status) || !"500".equals(status))) {
                        writer.println(startTime + ";" + time + ";");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("data/server.log", "data/target.csv");
    }
}
