package problem3;
import java.util.ArrayList;
public class Library {
    private int capacity;
    private ArrayList<Document> docs;

    public Library(int capacity){
        this.capacity=capacity;
        this.docs=new ArrayList<>();
    }

    public void displayDocuments(){
        if(docs.isEmpty()){
            System.out.println("No documents in the library.");
            return;
        }
        System.out.println("\n== Library Documents ==");
        for(Document d:docs){
            System.out.println(d);
        }
        System.out.println("Total documents: "+docs.size()+"/"+capacity);
    }

    public boolean add(Document doc){
        if(docs.size()<capacity){
            docs.add(doc);
            System.out.println("Document added successfully!");
            return true;
        }
        else{
            System.out.println("Library is full!");
            return false;
        }
    }

    public boolean delete(Document doc){
        if(docs.contains(doc)){
            docs.remove(doc);
            System.out.println("Document deleted successfully!");
            return true;
        }
        else{
            System.out.println("Document not found!");
            return false;
        }
    }

    public boolean deleteByNumber(int numRec){
        Document doc=document(numRec);
        if(doc!=null){
            docs.remove(doc);
            System.out.println("Document deleted successfully!");
            return true;
        }
        else{
            System.out.println("Document not found!");
            return false;
        }
    }

    public Document document(int numEnrg){
        for(Document doc: docs){
            if(doc.getNumRec()==numEnrg){
                return doc;
            }
        }
        return null;
    }
    
    public void displayAuthors(){
        ArrayList<String> authors=new ArrayList<>();
        for(Document doc : docs){
            String author=doc.getAuthor();
            if(author!=null && !author.trim().isEmpty()){
                String authorTrim = author.trim();
                if(!authors.contains(authorTrim)){ // This check might be case-sensitive
                    authors.add(authorTrim);
                }
            }
        }
        if(authors.isEmpty()){
            System.out.println("No authors found.");
        } else {
            System.out.println("\n== Authors List ==");
            for(String a:authors){
                System.out.println("- "+a);
            }
        }
    }

}
