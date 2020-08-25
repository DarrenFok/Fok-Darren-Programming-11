import org.junit.Before;
import org.junit.Test;
import java.util.Date;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

//test for Withdraw.toString()
public class WithdrawTest {
        Withdraw myTest;
        String test = "";

        @Before
        public void setup() {
            //public Date(int year,int month,int date,int hrs,int min, int sec)
            myTest = new Withdraw(200.0, new Date(120, 8, 23, 0, 0, 0), Customer.CHECKING);
        }

        @Test
        public void testWithdrawToString() {
            //print out length of the test
            System.out.println(test.length());
            //check whether the test is empty
            assertTrue(test.isEmpty());
            //assign string test to the toString method
            String test = myTest.toString();
            System.out.println(myTest);

            //AssertFalse that the test is not empty
            assertFalse(test.isEmpty());
        }
    }
