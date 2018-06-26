package test1;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.ToolProvider;
import javax.tools.JavaCompiler.CompilationTask;


public class CompilingTest {
    public static void main(String args[]) throws Exception {
        // Prepare source somehow.
        String mySource ="package test; public class Test { public static void main(String args[]){System.out.println(\"FUCK YOU MARVIN\");}}";
        String source = "package test; public class Test { static { System.out.println(\"hello\"); } public Test() { System.out.println(\"world\"); } public static void main(String args[]){System.out.println(\"FUCK YOU MARVIN\");}}";

// Save source in .java file.
        File root = new File("/java"); // On Windows running on C:\, this is C:\java.
        File sourceFile = new File(root, "test/Test.java");
        sourceFile.getParentFile().mkdirs();
        Files.write(sourceFile.toPath(), source.getBytes(StandardCharsets.UTF_8));

// Compile source file.
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        compiler.run(null, null, null, sourceFile.getPath());

// Load and instantiate compiled class.
        URLClassLoader classLoader = URLClassLoader.newInstance(new URL[]{root.toURI().toURL()});
        Class<?> cls = Class.forName("test.Test", true, classLoader); // Should print "hello".
        cls.newInstance();
    }
}