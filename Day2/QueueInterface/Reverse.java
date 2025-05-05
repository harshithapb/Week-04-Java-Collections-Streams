package QueueInterface;

import java.util.LinkedList;
import java.util.Queue;

public class Reverse {

    public static void reverseQueue(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return;
        }
        Integer element = queue.remove(); // Dequeue the front element
        reverseQueue(queue);             // Recursively reverse the remaining queue
        queue.add(element);              // Enqueue the dequeued element at the end
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);

        System.out.println("Original Queue: " + queue);

        reverseQueue(queue);

        System.out.println("Reversed Queue: " + queue);
    }
}