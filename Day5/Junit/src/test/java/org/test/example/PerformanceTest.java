package org.test.example;
import org.example.Performance;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;
public class PerformanceTest {
    Performance p = new Performance();
    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    void testLongRunningTask() {
        assertEquals("Task Completed", p.longRunningTask());
    }
}

