package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;

public class Analysis {

    public void unavailable(String source, String target) {
        ArrayList<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<String> availableList = new ArrayList<>();
        boolean isUnavailable = false;
        String startTime = null;
        for (String line : list) {
            String[] parts = line.split(" ");
            String status = parts[0];
            String time = parts[1];
            if ((status.equals("400") || status.equals("500")) && !isUnavailable) {
                startTime = time;
                isUnavailable = true;
            } else if (isUnavailable) {
                if (!(status.equals("400") || status.equals("500"))) {
                    availableList.add(startTime + ";" + time + ";");
                }
            }
        }
        try (PrintWriter writer = new PrintWriter(target)) {
            for (String time : availableList) {
                writer.println(time);
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
