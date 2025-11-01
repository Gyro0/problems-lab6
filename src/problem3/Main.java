package problem3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan=new Scanner(System.in);
        
        //Initialize library
        System.out.print("Enter the library's capacity: ");
        int n=scan.nextInt();
        scan.nextLine();
        Library lib=new Library(n);
        
        // Add initial documents
        Novel n1=new Novel("The Great Gatsby", "F. Scott Fitzgerald", 180, 15.99);
        Magazine m1=new Magazine("National Geographic", "January", 2024);
        lib.add(n1);
        lib.add(m1);
        
        // Menu
        int choice;
        do {
            System.out.println("\n=== Library Management System ===");
            System.out.println("1. Add a document");
            System.out.println("2. Display all documents");
            System.out.println("3. Delete a document");
            System.out.println("4. Search for a document");
            System.out.println("5. Display all authors");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice=scan.nextInt();
            scan.nextLine();
            
            switch(choice) {
                case 1:
                    addDocument(lib, scan);
                    break;
                case 2:
                    lib.displayDocuments();
                    break;
                case 3:
                    deleteDocument(lib, scan);
                    break;
                case 4:
                    searchDocument(lib, scan);
                    break;
                case 5:
                    lib.displayAuthors();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while(choice!=6);
        scan.close();
    }
    
    private static void addDocument(Library lib, Scanner scan) {
        System.out.println("\nSelect document type:");
        System.out.println("1. Novel");
        System.out.println("2. Textbook");
        System.out.println("3. Magazine");
        System.out.println("4. Dictionary");
        System.out.print("Enter your choice: ");
        int type=scan.nextInt();
        scan.nextLine();
        
        System.out.print("Enter title: ");
        String title=scan.nextLine();
        
        switch(type) {
            case 1:
                System.out.print("Enter author: ");
                String author=scan.nextLine();
                System.out.print("Enter number of pages: ");
                int pages=scan.nextInt();
                System.out.print("Enter price: ");
                double price=scan.nextDouble();
                scan.nextLine();
                lib.add(new Novel(title, author, pages, price));
                break;
            case 2:
                System.out.print("Enter author: ");
                author=scan.nextLine();
                System.out.print("Enter number of pages: ");
                pages=scan.nextInt();
                scan.nextLine();
                System.out.print("Enter level: ");
                String level=scan.nextLine();
                lib.add(new Textbook(title, author, pages, level));
                break;
            case 3:
                System.out.print("Enter month: ");
                String month=scan.nextLine();
                System.out.print("Enter year: ");
                int year=scan.nextInt();
                scan.nextLine();
                lib.add(new Magazine(title, month, year));
                break;
            case 4:
                System.out.print("Enter language: ");
                String language=scan.nextLine();
                lib.add(new Dictionary(title, language));
                break;
            default:
                System.out.println("Invalid type!");
        }
    }
    
    private static void deleteDocument(Library lib, Scanner scan) {
        System.out.print("Enter document number to delete: ");
        int numRec=scan.nextInt();
        scan.nextLine();
        lib.deleteByNumber(numRec);
    }
    
    private static void searchDocument(Library lib, Scanner scan) {
        System.out.print("Enter document number to search: ");
        int numRec=scan.nextInt();
        scan.nextLine();
        Document doc=lib.document(numRec);
        if(doc != null) {
            System.out.println("\nDocument found:");
            System.out.println(doc);
        } else {
            System.out.println("Document not found!");
        }
    }
}
