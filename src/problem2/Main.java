package problem2;

public class Main {
    public static void main(String[] args) {
        Customer c1 = new Customer("John");
        Customer c2 = new Customer("Brad");
        c1.deposit(100.2);
        c1.deposit(10.3);
        c1.withdraw(20.5);
        c2.deposit(1000);
        c2.withdraw(150);
        Bank b=new Bank("Bank Of Africa");
        b.addCustomer(c1);
        b.addCustomer(c2);
        b.addTransaction(c1, 50.0);
        b.printStatement("John");
    }
}
