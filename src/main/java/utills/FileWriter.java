package utills;

import java.nio.charset.StandardCharsets;
import java.nio.file.*;

public class FileWriter {

    static byte[] save;

    public String codePast(String pathToFile, String code) {
        try {
            Path path = Paths.get(pathToFile);
            byte[] data = Files.readAllBytes(path);
            save=Files.readAllBytes(path);
            String content = new String(data, StandardCharsets.UTF_8);
            content = content.replace("// REPLACE", code);
            data = content.getBytes();
            Files.write(path, data, StandardOpenOption.WRITE);
            return content;
        } catch (Exception e) {
            System.out.println(e);
        }
        return "FUCK";
    }
    public void restoreFile(String pathToFile){
        try {
            Path path = Paths.get(pathToFile);
            Files.delete(path);
            Files.write(path, save, StandardOpenOption.CREATE);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
