package models;
import org.junit.jupiter.api.Test;
import services.BankingService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Test
    public void testDeposit(){
        BankAccount bankAccount = new BankAccount("123456789",1000);
        bankAccount.deposit(500);
        assertEquals(1500,bankAccount.getBalance(), "deposit functionality bug");
    }


    @Test
    //Withdraw has a functionality has a requirement
    // withdraw should only be possible if the current balance is more or equal to the balance
    public void testWithdrawSuffcientFunds(){
        BankAccount bankAccount = new BankAccount("123456789",1000.00);
        boolean actualResult = bankAccount.withdraw(500.0);


     assertTrue(actualResult, "withdraw didnt return true");
     assertEquals(500.0,bankAccount.getBalance(),"Withdraw funds MisMatch");
}
@Test
public void testWithdrawSufficientFunds(){
        BankAccount bankAccount = new BankAccount("123456789",100.00);
        boolean actualResult = bankAccount.withdraw(200.00);

        assertFalse(actualResult,"Withdraw Return True with insufficient funds");
        assertEquals(100,bankAccount.getBalance(), "Insufficient fund altered the balance");
}



}
