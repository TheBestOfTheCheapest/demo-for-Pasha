package com.example.demo.service.core;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;


public class TaskRunner {
    private ByteArrayOutputStream trace = new ByteArrayOutputStream(2048);
    public String run(String sourceTemplate, String source, String taskName) throws Exception {

        File root = new File(System.getProperty("user.dir")); // On Windows running on C:\, this is C:\java.
        File sourceFile = new File(root.getPath(), taskName + ".java");
        try {
            // Prepare source somehow.
            source = sourceTemplate.replace("//REPLACE", source);

            // Save source
            Files.write(sourceFile.toPath(), source.getBytes(StandardCharsets.UTF_8));

            // Compile source file.
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            compiler.run(null, null, trace, sourceFile.getPath());

            // Load and instantiate compiled class.
            URLClassLoader classLoader = URLClassLoader.newInstance(new URL[]{root.toURI().toURL()});
            Class<?> cls = Class.forName(taskName, true, classLoader); // Should print "hello".
            cls.getDeclaredMethod("main", new Class[]{String[].class})
                    .invoke(null, new Object[]{null});

        }catch (Exception e){
            TaskLogger.writeLog("Compilation failure\n" + trace);
        }
        try {
            //Delete created files
            Files.delete(sourceFile.toPath());
            Files.delete(Paths.get(sourceFile.getPath().replace(".java", ".class")));
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
            return TaskLogger.readLog();


    }
}