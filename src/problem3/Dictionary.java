package problem3;

public class Dictionary extends Document {
    private String language;
    public Dictionary(String title,String language){
        super(title);
        this.language=language;
    }
    public String getLanguage(){return this.language;}

        @Override
    public String toString(){
        return "Dictionary [numRec="+getNumRec()+", title="+getTitle()+
               ", language="+language+"]";
    }
}
