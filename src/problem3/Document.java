package problem3;

public class Document {
    private static int counter=100;
    private int numRec;
    private String title;

    public Document(String title){this.numRec=counter++;this.title=title;}
    public int getNumRec(){return this.numRec;}
    public String getTitle(){return this.title;}
    public String getAuthor(){return null;}
    @Override
    public String toString(){
        return "Document [numRec="+numRec+", title="+title+"]";
    }
}
