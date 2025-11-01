package problem5;

import java.util.LinkedList;

public class BookStack {
    private LinkedList<Book> stack;

    public BookStack() {
        this.stack=new LinkedList<Book>();
    }

    public void push(Book book) {
        this.stack.addFirst(book);
    }

    public Book pop() {
        // code here and don't to test if it's empty
        return this.stack.removeFirst();
    }

    public Book peek() {
        // code here and don't to test if it's empty
        return this.stack.getFirst();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void display() {
        LinkedList<Book> copy=new LinkedList<>(stack);
        System.out.println("Stack contents (top to bottom):");
        while (!copy.isEmpty()){
            System.out.println("- "+copy.removeFirst());
        }
    }
}

