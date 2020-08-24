import javax.security.sasl.SaslClient;
import java.util.ArrayList;
import java.util.Date;

public class Customer {
    private int accountNumber;
    private ArrayList<Deposit> deposits = new ArrayList<Deposit>();
    private ArrayList<Withdraw> withdraws = new ArrayList<Withdraw>();
    private double checkBalance;
    private double savingBalance;
    private double savingRate;
    private String name;
    public static final String CHECKING = "Checking";
    public static final String SAVING = "Saving";
    private final int OVERDRAFT = -100;

    Customer(){
        //create default constructor
        accountNumber = 0;
        checkBalance = 0;
        savingBalance = 0;
        savingRate = 0;
        name = "";
    }
    Customer(String name, int accountNumber, double checkDeposit, double savingDeposit){
        //constructor code here
        this.accountNumber = accountNumber;
        this.checkBalance = checkBalance + checkDeposit;
        this.savingBalance = savingBalance + savingDeposit;
        this.name = name;
    }

    //Requires: double, date, account
    //Modifies: double checkBalance, double savingBalance, ArrayList deposits
    //Effects: adds new deposits to the deposits ArrayList, adds amount deposited in savingBalance or checkBalance
    public double deposit(double amt, Date date, String account){
        //your code here
        new Deposit(amt, date, account);
        if(account.equals(CHECKING)){
            this.checkBalance = this.checkBalance + amt;
            deposits.add(new Deposit(amt, date, account));
        }
        else if(account.equals(SAVING)){
            this.savingBalance = this.savingBalance + amt;
            deposits.add(new Deposit(amt, date, account));
        }
        return 0;
    }
    //Requires: double, date, String
    //Modifies: double checkBalance, double savingBalance, arrayList withdraws
    //Effects: adds new withdrawals to the withdraws ArrayList, subtracts amount withdrawn from savingsBalance or checkBalance
    public double withdraw(double amt, Date date, String account){
        //your code here
        new Withdraw(amt, date, account);
        if(account.equals(CHECKING)){
            if(!checkOverdraft(amt, CHECKING)){
                this.checkBalance = this.checkBalance - amt;
                withdraws.add(new Withdraw(amt, date, account));
            }
            else{
                System.out.println("OVERDRAFT error: Checking account balance is below -$100.00");
            }
        }
        if(account.equals(SAVING)){
            if(!checkOverdraft(amt, SAVING)){
                this.savingBalance = this.savingBalance - amt;
                withdraws.add(new Withdraw(amt, date, account));
            }
            else{
                System.out.println("OVERDRAFT error: Savings account balance is below -$100.00");
            }
        }
        return 0;
    }

    //Requires: double, account
    //Modifies: nothing
    //Effects: tells us if our checking or savings account goes into overdraft/is less than OVERDRAFT (overdraft is when the account balance goes below 0,
    //         but in this case, it is -100).
    private boolean checkOverdraft(double amt, String account){
        //your code here
        if(account.equals(CHECKING)){
            if((checkBalance - amt) < OVERDRAFT){
                return true;
            }
        }
        if(account.equals(SAVING)){
            if((savingBalance - amt) < OVERDRAFT){
                return true;
            }
        }
        return false;
    }
    //do not modify
    public void displayDeposits(){
        for(Deposit d : deposits){
            System.out.println(d);
        }
    }
    //do not modify
    public void displayWithdraws(){
        for(Withdraw w : withdraws){
            System.out.println(w);
        }
    }
    public Date getCurrentDate(){
        Date dateobj = new Date();
        return dateobj;
    }
}
