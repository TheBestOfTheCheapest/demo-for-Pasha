package com.example.demo.service.core;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MyTest {
    public static void main(String[] args) throws Exception {
        TaskRunner taskRunner = new TaskRunner();
        Path path = Paths.get("C:\\Users\\kshegolev\\Desktop\\demo\\src\\main\\java\\com.example.demo.service.core\\MatrixSumm.java");
        String source = "        for (int i=0;i<5;i++){\n" +
                "            for (int j=0;i<5;i++){\n" +
                "                if((i==j) || (i==(5-j-1)))\n" +
                "                    summ += array[i][j];\n" +
                "            }\n" +
                "}";
        taskRunner.run(new String(Files.readAllBytes(path), StandardCharsets.UTF_8),source, "MatrixSumm");
    }
}
