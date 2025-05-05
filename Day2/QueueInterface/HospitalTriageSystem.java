package QueueInterface;

import java.util.PriorityQueue;

class Patient {
    String name;
    int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    public String getName() {
        return name;
    }

    public int getSeverity() {
        return severity;
    }

    @Override
    public String toString() {
        return "(" + name + ", Severity: " + severity + ")";
    }
}

public class HospitalTriageSystem {

    public static void main(String[] args) {
        // Create a PriorityQueue that prioritizes patients with higher severity (higher integer value)
        PriorityQueue<Patient> triageQueue = new PriorityQueue<>((p1, p2) -> Integer.compare(p2.getSeverity(), p1.getSeverity()));

        // Add patients to the triage queue
        triageQueue.offer(new Patient("John", 3));
        triageQueue.offer(new Patient("Alice", 5));
        triageQueue.offer(new Patient("Bob", 2));
        triageQueue.offer(new Patient("Charlie", 4));
        triageQueue.offer(new Patient("Diana", 1));
        triageQueue.offer(new Patient("Eve", 5)); // Another patient with high severity

        System.out.println("Patients in Triage Queue (Higher Severity First):");
        while (!triageQueue.isEmpty()) {
            Patient nextPatient = triageQueue.poll();
            System.out.println("Treating: " + nextPatient);
        }
    }
}