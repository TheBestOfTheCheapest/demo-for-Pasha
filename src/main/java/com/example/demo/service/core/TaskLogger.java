package com.example.demo.service.core;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TaskLogger {
    public static void writeLog(String log) throws IOException {
        File logFile = new File(System.getProperty("user.dir"), "log.txt"); // On Windows running on C:\, this is C:\java.
        Files.write(logFile.toPath(), log.getBytes(StandardCharsets.UTF_8));
    }

    public static String readLog() throws IOException {
        Path path = Paths.get(System.getProperty("user.dir") + "\\log.txt");
        String log = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
        try {
            deleteLog(path);
        } catch (IOException e) {
            System.out.println(e);
        }

        return log;
    }

    private static void deleteLog(Path path) throws IOException {
        Files.delete(path);
    }
}
