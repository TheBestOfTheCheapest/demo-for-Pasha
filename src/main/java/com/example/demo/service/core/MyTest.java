package com.example.demo.service.core;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MyTest {
    public static void main(String[] args) throws Exception {

        TaskRunner taskRunner = new TaskRunner();
                String source = "    private int calculateMatrix(int[][] array) {\n" +
                "        int summ = 0;\n" +
                "        for (int i = 0; i < 5; i++) {\n" +
                "            for (int j = 0; j < 5; j++) {\n" +
                "                if ((i == j) || (i == (5 - j - 1)))\n" +
                "                    summ += array[i][j];\n" +
                "            }\n" +
                "        }\n" +
                "        return summ;\n" +
                "    }";
        System.out.println(taskRunner.run(Searcher.getSource("MatrixSumm"),source, "MatrixSumm"));
    }
}
