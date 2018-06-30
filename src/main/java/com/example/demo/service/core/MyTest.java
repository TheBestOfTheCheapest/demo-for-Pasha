package com.example.demo.service.core;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MyTest {
    public static void main(String[] args) throws Exception {

        TaskRunner taskRunner = new TaskRunner();
                String source = "    public int result(String text) {\n" +
                        "        return text.replaceAll(\"s\", \"\").lastIndexOf(\"Ф\");\n" +
                        "    }";
        System.out.println(taskRunner.run(Searcher.getSource("TextRefactor"),source, "TextRefactor"));
    }
}
