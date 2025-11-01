package problem3;

public class Book extends Document{
    private String author;
    private int nbrPages;
    
    public Book(String title,String author,int nbrPages){
        super(title);
        this.author=author;
        this.nbrPages=nbrPages;
    }
    public String getAuthor(){return this.author;}
    public int getNbrPages(){return this.nbrPages;}
    @Override
    public String toString(){
        return "Book [numRec="+getNumRec()+", title="+getTitle() + 
               ", author="+author+", pages="+nbrPages + "]";
    }
}
