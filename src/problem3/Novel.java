package problem3;

public class Novel extends Book{
    private double price;
    public Novel(String title,String author,int nbrPages,double price){
        super(title, author, nbrPages);
        this.price=price;
    }
    public double getPrice(){return this.price;}
    @Override
    public String toString(){
        return "Novel [numRec="+getNumRec()+", title="+getTitle()+ 
               ", author="+getAuthor()+", pages="+getNbrPages() + 
               ", price=$"+price+"]";
    }
}
