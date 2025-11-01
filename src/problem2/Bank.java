package problem2;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Customer> customers;

    public Bank(String name){
        this.name=name;
        this.customers = new ArrayList<>(); 

    }
    public void addCustomer(Customer c){
        if(c!=null && !customers.contains(c)){
            customers.add(c);
            System.out.println("Customer added successfully.");
            return;
        }
        System.out.println("Customer already in list.");
        return;
    }

    public void addTransaction(Customer c,double amount){
        for(Customer cus :customers){
            if( cus.getName().equals(c.getName())){
                if(amount<0.0){
                    cus.withdraw(-amount);
                    return;
                }
                else{
                    cus.deposit(amount);
                    return;
                }
            }
        }
        System.out.println("Customer not found.");
    }
    public void printStatement(String name){
        for(Customer c:customers){
            if(c.getName().equalsIgnoreCase(name)){
                System.out.println("Statement for: " + c.getName());
                System.out.println("Transactions :");
                ArrayList<Double> trans=c.getTransactions();
                double balance=0.0;
                for(Double t:trans){
                    double transactionAmount=t;
                    balance+=t;
                    System.out.printf("$%.2f\n",transactionAmount);
                }
                System.out.println();
                System.out.printf("Current Balance: $%.2f\n",balance);
                return;
            }
        }
        System.out.println("Customer not found");

    }
}
