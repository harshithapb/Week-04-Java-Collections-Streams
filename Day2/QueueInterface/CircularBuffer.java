package QueueInterface;

public class CircularBuffer {
    private int[] buffer;
    private int head; // Index of the next element to be read
    private int tail; // Index of the next empty slot to write
    private int size; // Maximum capacity of the buffer
    private int count; // Current number of elements in the buffer

    public CircularBuffer(int size) {
        this.size = size;
        this.buffer = new int[size];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }

  
    public void enqueue(int data) {
        buffer[tail] = data;
        tail = (tail + 1) % size; // Move tail to the next position, wrapping around if necessary
        if (count == size) {
            head = (head + 1) % size; // If full, move head to overwrite the oldest
        } else {
            count++;
        }
    }


    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Buffer is empty");
            return -1; // Indicate empty buffer
        }
        int data = buffer[head];
        head = (head + 1) % size; // Move head to the next oldest element
        count--;
        return data;
    }

   
    public int peek() {
        if (isEmpty()) {
            System.out.println("Buffer is empty");
            return -1; // Indicate empty buffer
        }
        return buffer[head];
    }

    
    public boolean isEmpty() {
        return count == 0;
    }

   
    public boolean isFull() {
        return count == size;
    }

   
    public int size() {
        return count;
    }

  
    public void printBuffer() {
        if (isEmpty()) {
            System.out.println("Buffer is empty.");
            return;
        }
        System.out.print("Buffer: [");
        int current = head;
        for (int i = 0; i < count; i++) {
            System.out.print(buffer[current]);
            if (i < count - 1) {
                System.out.print(", ");
            }
            current = (current + 1) % size;
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        CircularBuffer buffer = new CircularBuffer(3);

        System.out.println("Initial state:");
        buffer.printBuffer();
        System.out.println("Is empty: " + buffer.isEmpty());
        System.out.println("Is full: " + buffer.isFull());

        System.out.println("\nInserting 1, 2, 3:");
        buffer.enqueue(1);
        buffer.enqueue(2);
        buffer.enqueue(3);
        buffer.printBuffer();
        System.out.println("Is empty: " + buffer.isEmpty());
        System.out.println("Is full: " + buffer.isFull());

        System.out.println("\nInserting 4 (overwrites oldest):");
        buffer.enqueue(4);
        buffer.printBuffer();
        System.out.println("Is empty: " + buffer.isEmpty());
        System.out.println("Is full: " + buffer.isFull());

        System.out.println("\nDequeueing:");
        System.out.println("Dequeued: " + buffer.dequeue());
        buffer.printBuffer();
        System.out.println("Is empty: " + buffer.isEmpty());
        System.out.println("Is full: " + buffer.isFull());

        System.out.println("\nInserting 5:");
        buffer.enqueue(5);
        buffer.printBuffer();
        System.out.println("Is empty: " + buffer.isEmpty());
        System.out.println("Is full: " + buffer.isFull());

        System.out.println("\nDequeueing all:");
        System.out.println("Dequeued: " + buffer.dequeue());
        System.out.println("Dequeued: " + buffer.dequeue());
        System.out.println("Dequeued: " + buffer.dequeue());
        buffer.printBuffer();
        System.out.println("Is empty: " + buffer.isEmpty());
        System.out.println("Is full: " + buffer.isFull());

        System.out.println("\nDequeue from empty buffer:");
        buffer.dequeue();
    }
}