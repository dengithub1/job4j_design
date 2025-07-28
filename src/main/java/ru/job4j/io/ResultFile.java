package ru.job4j.io;

import java.io.FileOutputStream;
import java.io.IOException;

public class ResultFile {
    public static void main(String[] args) {
        try (FileOutputStream outputStream = new FileOutputStream("data/dataresult.txt")) {
            outputStream.write("1 * 9 = 9".getBytes());
            outputStream.write(System.lineSeparator().getBytes());
            outputStream.write("2 * 9 = 18".getBytes());
            outputStream.write(System.lineSeparator().getBytes());
            outputStream.write("3 * 9 = 27".getBytes());
            outputStream.write(System.lineSeparator().getBytes());
            outputStream.write("4 * 9 = 36".getBytes());
            outputStream.write(System.lineSeparator().getBytes());
            outputStream.write("5 * 9 = 45".getBytes());
            outputStream.write(System.lineSeparator().getBytes());
            outputStream.write("6 * 9 = 54".getBytes());
            outputStream.write(System.lineSeparator().getBytes());
            outputStream.write("7 * 9 = 63".getBytes());
            outputStream.write(System.lineSeparator().getBytes());
            outputStream.write("8 * 9 = 72".getBytes());
            outputStream.write(System.lineSeparator().getBytes());
            outputStream.write("9 * 9 = 81".getBytes());
            outputStream.write(System.lineSeparator().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
