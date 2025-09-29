package ru.job4j.io;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.nio.file.Path;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class AnalysisTest {

    @Test
    public void oneAvailableSlot(@TempDir Path tempDir) {
        File source = tempDir.resolve("source.log").toFile();
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(source))) {
            writer.println("200 10:56:01");
            writer.println("500 10:57:01");
            writer.println("400 10:58:01");
            writer.println("500 10:59:01");
            writer.println("400 11:01:02");
            writer.println("300 11:02:02");
        } catch (IOException e) {
            e.printStackTrace();
        }
        File target = tempDir.resolve("target.csv").toFile();
        StringBuilder result = new StringBuilder();
        new Analysis().unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(target))) {
            bufferedReader.lines().forEach(e -> result.append(e));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(result);
        assertThat("10:57:01;11:02:02;").hasToString(result.toString());
    }
}