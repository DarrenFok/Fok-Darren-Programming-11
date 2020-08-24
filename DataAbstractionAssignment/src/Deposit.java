import java.util.Date;

public class Deposit {
    private double amount;
    private Date date;
    private String account;

    Deposit(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    //Requires: nothing
    //Modifies: this
    //Effects: replaces default toString() method with what we want printed out
    public String toString(){
        //your code here
        return "Deposit of: $" + amount + " Date:" + date + " into account: " + account;
    }
}
