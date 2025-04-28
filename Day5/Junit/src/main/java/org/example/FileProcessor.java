package org.example;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
public class FileProcessor {
    public void writeToFile(String filename, String content) throws IOException {
        Files.writeString(Path.of(filename), content);
    }
    public String readFromFile(String filename) throws IOException {
        return Files.readString(Path.of(filename));
    }
    public boolean fileExists(String filename) {
        return Files.exists(Path.of(filename));
    }
}

