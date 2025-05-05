package QueueInterface;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {

    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public StackUsingQueues() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

   
    public void push(int x) {
        queue2.offer(x);
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        // Swap queue1 and queue2 so that queue2 always has the top element at the front
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    
    public Integer pop() {
        if (queue1.isEmpty()) {
            return null;
        }
        return queue1.poll();
    }

   
    public Integer top() {
        if (queue1.isEmpty()) {
            return null;
        }
        return queue1.peek();
    }

  
    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top element: " + stack.top()); // Output: 3
        System.out.println("Pop: " + stack.pop());       // Output: 3
        System.out.println("Top element after pop: " + stack.top()); // Output: 2
        System.out.println("Is empty: " + stack.isEmpty()); // Output: false
        System.out.println("Pop: " + stack.pop());       // Output: 2
        System.out.println("Pop: " + stack.pop());       // Output: 1
        System.out.println("Is empty: " + stack.isEmpty()); // Output: true
        System.out.println("Pop from empty stack: " + stack.pop()); // Output: null
        System.out.println("Top from empty stack: " + stack.top()); // Output: null
    }
}