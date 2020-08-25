import org.junit.Before;
import org.junit.Test;
import java.util.Date;

import static org.junit.Assert.assertEquals;


//test class for Customer.deposit() and Customer.withdraw()
public class CustomerTests {
    Customer testCustomer;

    @Before
    public void setup(){
        testCustomer = new Customer("Default",1325,300.0, 200.0);
    }

    @Test
    public void testCustomerDeposit(){
        //checks whether ArrayList is empty
        assertEquals(testCustomer.getDeposits().size(),0);

        //deposit money into user's checking account
        testCustomer.deposit(300.0, new Date(120,4,22,0,0,0),Customer.CHECKING);

        //check whether the size of the ArrayList increased by 1
        assertEquals(testCustomer.getDeposits().size(),1);

        //deposit money into user's checking account
        testCustomer.deposit(200.0, new Date(120,4,23,0,0,0), Customer.SAVING);

        //check whether the size of the ArrayList increased by 1
        assertEquals(testCustomer.getDeposits().size(), 2);

    }

    @Test
    public void testCustomerWithdraw(){
        //check whether ArrayList is empty
        assertEquals(testCustomer.getWithdraws().size(), 0) ;

        //withdraw money from savings account
        testCustomer.withdraw(300.0, new Date(115,4,24,0,0,0),Customer.SAVING);

        //check that the withdrawal was added to the ArrayList
        assertEquals(testCustomer.getWithdraws().size(), 1);

        //withdraw money from savings account
        testCustomer.withdraw(300.0, new Date(120,4,25,0,0,0),Customer.CHECKING);

        //check that the withdrawal was added to the ArrayList
        assertEquals(testCustomer.getWithdraws().size(), 2);

        //test OVERDRAFT by withdrawing money from checking
        testCustomer.withdraw(300.0, new Date(120,5,23,0,0,0),Customer.CHECKING);
        //test OVERDRAFT by withdrawing money from checking
        testCustomer.withdraw(300.0, new Date(120,5,23,1,0,0),Customer.SAVING);

        //since withdrawals didn't go through, the ArrayList size should be 2.
        assertEquals(testCustomer.getWithdraws().size(), 2);
    }
}
