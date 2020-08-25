import java.util.Date;

public class Main {
    public static void main(String[] args) {
        //Customer information
        Customer test = new Customer("Test", 88888, 100.00, 300.00);

        /*
        Deposit of: $400.0 Date:Sun Nov 04 00:00:00 PDT 2018 into account: Checking
        Deposit of: $500.0 Date:Sun Sep 16 10:52:17 PDT 2018 into account: Saving
        */
        test.deposit(400.00, new Date(118, 10,4,0,0,0),Customer.CHECKING);
        test.deposit(500.00, new Date(118, 8, 16, 10, 52, 17), Customer.SAVING);

        /*Test OVERDRAFT error on each account
        OVERDRAFT error: Checking account balance is below -$100.00
        OVERDRAFT error: Savings account balance is below -$100.00
         */
        test.withdraw(601.00, new Date(118, 11, 1, 0,0,0), Customer.CHECKING);
        test.withdraw(901.00, new Date(118,11,1,0,0,0), Customer.SAVING);

        /*
        Withdrawal of: $100.0 Date: Sat Dec 01 00:00:00 PST 2018 into account: Checking
        Withdrawal of: $100.0 Date: Sat Dec 01 00:00:00 PST 2018 into account: Saving
        */
        test.withdraw(100, new Date(118, 11,1,0,0,0), Customer.CHECKING);
        test.withdraw(100, new Date(118,11,1,0,0,0), Customer.SAVING);

        //Display deposits and withdrawals
        test.displayDeposits();
        test.displayWithdraws();
    }
}
