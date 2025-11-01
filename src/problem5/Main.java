package problem5;

public class Main {
    public static void main(String[] args) {
        // Test Stack (LIFO)
        System.out.println("=== Stack Test ===");
        BookStack stack = new BookStack();
        
        // Push books onto stack
        stack.push(new Book("The Hobbit","J.R.R. Tolkien",1937));
        stack.push(new Book("1984","George Orwell",1949));
        stack.push(new Book("Clean Code","Robert C. Martin",2008));
        
        // Display stack
        stack.display();
        
        // Pop a book
        System.out.println("Popped: "+stack.pop());
        
        // Peek at top
        System.out.println("Top: "+stack.peek());
        
        // Display stack again
        stack.display();
        
        System.out.println("\n=== Queue Test ===");
        BookQueue queue = new BookQueue();
        
        // Enqueue books
        queue.enqueue(new Book("The Hobbit","J.R.R. Tolkien",1937));
        queue.enqueue(new Book("1984","George Orwell",1949));
        queue.enqueue(new Book("Clean Code","Robert C. Martin",2008));
        
        // Display queue
        queue.display();
        
        // Dequeue a book
        System.out.println("Dequeued: "+queue.dequeue());
        
        // Peek at front
        System.out.println("Front: "+queue.peek());
        
        // Display queue again
        queue.display();
    }
}
