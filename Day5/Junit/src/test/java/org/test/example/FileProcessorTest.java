package org.test.example;
import org.example.FileProcessor;
import org.junit.jupiter.api.*;
import java.io.IOException;
import java.nio.file.*;
import static org.junit.jupiter.api.Assertions.*;
public class FileProcessorTest {
    private FileProcessor fileProcessor;
    private final String filename = "input.txt";
    @BeforeEach
    void setup() {
        fileProcessor = new FileProcessor();
    }
    @AfterEach
    void cleanup() throws IOException {
        Files.deleteIfExists(Path.of(filename));
    }
    @Test
    void testWriteAndReadFile() throws IOException {
        String content = "Hello World";
        fileProcessor.writeToFile(filename, content);
        String result = fileProcessor.readFromFile(filename);
        assertEquals(content, result);
    }
    @Test
    void testFileExistsAfterWriting() throws IOException {
        fileProcessor.writeToFile(filename, "data");
        assertTrue(fileProcessor.fileExists(filename));
    }
    @Test
    void testReadNonExistentFileThrowsException() {
        assertThrows(IOException.class, () -> fileProcessor.readFromFile("nonexistent.txt"));
    }
}

