/*
 * Developed by Andrey Yelmanov
 * Copyright (c) 2019.
 */

package ru.digitalleague.demo.service.core;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Searcher {

    public static String getSource(String name) throws IOException {
        File file = searchFile(name);
        return new String(Files.readAllBytes(Paths.get(file.getPath())), StandardCharsets.UTF_8);
    }

    private static File searchFile(String name) {
        String fs = System.getProperty("file.separator");
        System.out.println("System: " + System.getProperty("os.name") + "; Separator: " + fs);
        StringBuilder b = new StringBuilder(fs).append("src").append(fs).append("main").append(fs).append("resources").append(fs).append("SourceTemplate");
        String filePath = b.toString();
        File folder = new File(System.getProperty("user.dir") + filePath);
        for (File f : folder.listFiles()) {
            if ((name + ".txt").equals(f.getName())) {
                return f;
            }
        }
        return null;
    }
}
