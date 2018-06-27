package com.example.demo.service.core;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;


public class TaskRunner {
    public void run(String sourceTemplate, String source, String taskName) throws Exception {
        // Prepare source somehow.
        source = sourceTemplate.replace("//REPLACE", source);
        // Save source
        File root = new File(System.getProperty("user.dir")); // On Windows running on C:\, this is C:\java.
        File sourceFile = new File(root.getPath(), taskName + ".java");
        Files.write(sourceFile.toPath(), source.getBytes(StandardCharsets.UTF_8));
        // Compile source file.
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        compiler.run(null, null, null, sourceFile.getPath());
        // Load and instantiate compiled class.
        URLClassLoader classLoader = URLClassLoader.newInstance(new URL[]{root.toURI().toURL()});
        Class<?> cls = Class.forName(source.substring(8, source.indexOf(";")) + "." + taskName, true, classLoader); // Should print "hello".
        cls.getDeclaredMethod("main", new Class[]{String[].class})
                .invoke(null, new Object[]{null});
        //Delete created files
        Files.delete(sourceFile.toPath());
        Files.delete(Paths.get(sourceFile.getPath().replace(".java", ".class")));
    }
}