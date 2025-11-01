package problem3;

public class Magazine extends Document{
    String month;
    int year;
    public Magazine(String title,String month,int year){
        super(title);
        this.month=month;
        this.year=year;
    }
    public String getMonth(){return this.month;}
    public int getYear(){return this.year;}
    @Override
    public String toString(){
        return "Magazine [numRec="+getNumRec()+", title="+getTitle()+
               ", month="+month+", year="+year+"]";
    }
}
