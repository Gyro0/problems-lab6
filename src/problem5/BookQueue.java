package problem5;

import java.util.LinkedList;

public class BookQueue {
    private LinkedList<Book> queue;

    public BookQueue(){
        this.queue=new LinkedList<Book>();
    }
    public void enqueue(Book book){
        queue.addLast(book);
    }
    public Book dequeue(){
        return queue.removeFirst();
    }
    public Book peek(){
        return queue.getFirst();
    }

    public void display() {
        LinkedList<Book> copy=new LinkedList<>(queue);
        System.out.println("Queue contents (front to back):");
        while (!copy.isEmpty()) {
            System.out.println("- "+copy.removeFirst());
        }
    }
}
