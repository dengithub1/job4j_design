package ru.job4j.io;

import java.io.FileInputStream;
import java.io.IOException;

public class EvenNumerFile {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("data/even.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = fis.read()) != -1) {
                text.append((char) read);
            }
            String[] strings = text.toString().split(System.lineSeparator());
            for (String even : strings) {
                if (Integer.parseInt(even) % 2 == 0) {
                    System.out.println(even);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
