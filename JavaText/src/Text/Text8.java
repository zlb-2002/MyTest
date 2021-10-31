package Text;


import java.util.Date;
import java.util.Scanner;

class Account {
    private int id;
    private double balance;
    private double annualIntererstRate;
    private Date dateCreated;

    public Account(int id, double balance, double annualIntererstRate, Date dateCreated) {
        this.id = id;
        this.balance = balance;
        this.annualIntererstRate = annualIntererstRate;
        this.dateCreated = dateCreated;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualintererstRate() {
        return annualIntererstRate;
    }

    public void setAnnualintererstRate(double annualintererstRate) {
        this.annualIntererstRate = annualintererstRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public double getMonthlyInterestrate() {
        return this.annualIntererstRate/12;
    }

    public double getMonthlyInterest() {
        return balance * (getAnnualintererstRate()/100);
    }

    public double withdraw(double money) {
        this.balance = this.balance - money;
        return this.balance;

    }

    public double deposit(double money) {
        this.balance = this.balance + money;
        return this.balance;
    }

}



public class Text8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        double balance = sc.nextDouble();
        double annualInterestRate = sc.nextDouble();
        Account account = new Account(id, balance, annualInterestRate, new Date());
        System.out.println(account.getId());
        System.out.println(account.getBalance());

    }

}
