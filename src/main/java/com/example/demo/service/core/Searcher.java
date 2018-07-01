package com.example.demo.service.core;

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
        File folder = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\SourceTemplate");
        for (File f : folder.listFiles()) {
            if ((name + ".txt").equals(f.getName())) {
                return f;
            }
        }
        return null;
    }
}
