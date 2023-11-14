package services;

import models.BankAccount;
import models.Customer;
import models.Transaction;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

 public class BankingServiceTest {
   static BankingService bankingService;
    BankAccount bankAccount1;
    Customer customer1;
    //PreCondition
//When you see lines of code that are repeating in every single
    // test within one test class
    //those lines are good candidates to be moved to
    //@beforeEach, @beforeAll, @afterAll, @afterEach -> these are called hooks
    @BeforeAll
   public static void beforeAll(){
        bankingService = new BankingService();
    }
    @BeforeEach
    public void setUpEachTest(){
        // PRE - CONDITION
         bankAccount1 = new BankAccount("12345", 1000.0);
         customer1 = new Customer("Elon Musk", "x1", bankAccount1);
    }

    @AfterEach
    public void cleanUp(){
        // start every test from empty cache.
        // so that it ensures each test are starting from of app's default state
        // and each test is independent from each other.
        bankingService.clearCache();
    }

    @Test
    public void addingNewCustomerTest() {
        // this is action test
        bankingService.addCustomer(customer1);

        List<Customer> expectedListOfCustomer = new ArrayList<>();
        expectedListOfCustomer.add(customer1);

        assertEquals(expectedListOfCustomer, bankingService.getCustomersList(), "Customer List is not equal");
    }
    @Test
    public void findingCustomerWithin1CustomerList(){


        bankingService.addCustomer(customer1);

        Customer actualResultCustomerObj = bankingService.findCustomer("x1");
        assertEquals(actualResultCustomerObj.getName(),"Elon Musk");
        assertEquals(actualResultCustomerObj.getName(),"Elon Musk");
    }

    @Test
    public void positiveFindingWithinCustomerTest() {

        //action test step
        bankingService.addCustomer(customer1);

        List<Customer> expectedCustomersList = new ArrayList<>();
        expectedCustomersList.add(customer1);

        // Use assertIterableEquals to compare the contents of the lists
        assertIterableEquals(expectedCustomersList, bankingService.getCustomersList());

    }

    @Test
    public void findingCustomerThatDoesntExist() {

        bankingService.addCustomer(customer1);

        Customer actualCustomerObj = bankingService.findCustomer("gr77r9jv");

        assertNull(actualCustomerObj, "Finding a Cutomer that doesnt exist should return Null");
    }

    @Test
    public void findingCustomersAndListReturnsEmpty() {

        //test action step
        assertTrue(bankingService.getCustomersList().isEmpty());

    }

    @Test
    public void findingBankAccountTest() {


        //action test step
        bankingService.findAccountMethod(bankAccount1.getAccountNumber());

        List<BankAccount> expectedBankAccountList = new ArrayList<>();
        expectedBankAccountList.add(bankAccount1);

        // Use assertIterableEquals to compare the contents of the lists
        assertEquals(expectedBankAccountList, bankingService);

    }

    @Test
    public void performTransactionWithNullCustomer() {


        Transaction transaction1 = new Transaction("TXN001", "Deposit", 500.0, "12345", "x1");
        try {
            assertThrows(Exception.class, () -> bankingService.performTransaction(transaction1));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void testPerformDepositTransaction() throws Exception {

        Transaction transaction1 = new Transaction("TXN001", "Deposit", 500.0, "12345", "x1");

        bankingService.addCustomer(customer1);
        try {
            bankingService.performTransaction(transaction1);

            assertEquals(1500.00, bankAccount1.getBalance(), "Deposit is not complete");
        } catch (Exception e) {
            fail("Perform transaction with a valid transaction failed");
            //fail is an assertion if something goes wrong this is the message
        }

    }
    @Test
    public void testPerformWithdrawWithSufficientFunds(){

        Transaction transaction1 = new Transaction("TXN001", "Withdraw", 300.0, "12345", "x1");

        //action step
        bankingService.addCustomer(customer1);
        try {
            bankingService.performTransaction(transaction1);

            assertEquals(700.00,bankAccount1.getBalance(),"withdraw balance mismatch");
        }catch (Exception e){
            fail("Withdraw with sufficient funds is not completed"+ e.getMessage());
        }
      }
    @Test
    public void testPerformWithdrawWithInsufficientFunds(){


        Transaction transaction1 = new Transaction("TXN001", "Withdraw", 1500.0, "12345", "x1");

        //action step
        bankingService.addCustomer(customer1);
        try {
            bankingService.performTransaction(transaction1);

            assertEquals(1000.00,bankAccount1.getBalance(),"withdraw balance mismatch");
        }catch (Exception e){
            fail("Withdraw with insufficient funds error"+ e.getMessage());
        }
    }
    }



