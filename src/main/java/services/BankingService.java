package services;

import models.BankAccount;
import models.Customer;

import java.util.ArrayList;
import java.util.List;
import models.Transaction;


public class BankingService {
    // in this class we write the fucntionalities

    // all collections declared as instance variable are called
    // cache - cache is a short term memory
    private List<Customer> customersList;
    private List <Transaction> transactionList;

    public BankingService() {
        this.customersList = new ArrayList<>();
        this.transactionList = new ArrayList<>();
    }
    public void addCustomer(Customer customer){

        customersList.add(customer);
    }

    public Customer findCustomer(String customerId){
        for(Customer customer: customersList){
            if (customer.getCustomerId().equals(customerId)){
                return customer;
            }
        }
        return null;
    }

    public BankAccount findAccountMethod(String accountId){
        for (Customer customer : customersList){
            if (customer.getBankAccount().getAccountNumber().equals(accountId)){
                return customer.getBankAccount();
            }
        }
        return null;
    }


public void performTransaction(Transaction transaction) throws Exception {
    String accountId = transaction.getAccountId();
    BankAccount account = findAccountMethod(accountId);

    if (account != null) {
        String customerId = transaction.getCustomerId(); // if this account isnt null print out the customer Id from the transaction class
        Customer customer = findCustomer(customerId);

        if (customer != null) {
            if (transaction.getType().equals("Deposit")) {
                account.deposit(transaction.getAmount());
            } else if (transaction.getType().equals("Withdraw")) {
                account.withdraw(transaction.getAmount());
            }

            transactionList.add(transaction);

        } else {
            throw new Exception("Customer not found");
        }

    } else {
        throw new Exception("Account not found");
    }
}
    public List<Customer> getCustomerList(){ return customersList;}

    public void clearCache(){
        customersList.clear();
        transactionList.clear();
    }


    public List<Customer> getCustomersList() {
        return customersList;
    }
}



