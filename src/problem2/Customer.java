package problem2;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactions;

    public Customer(String name){
        this.name=name;
        this.transactions= new ArrayList<>();
    }
    public String getName(){return this.name;}

    public ArrayList<Double> getTransactions(){return this.transactions;}

    public void withdraw(double amount){
        this.transactions.add(Double.valueOf(-amount));
    }
    public void deposit(double amount){
        this.transactions.add(Double.valueOf(amount));
    }

}
