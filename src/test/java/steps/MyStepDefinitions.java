package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepDefinitions {

    @Given("a bank account with account number {string} and balance {string} in GBP")
    public void a_bank_account_with_account_number_and_balance_in_gbp(String accountNumber, String balance) {
        // Implement your logic here
        // For example, you can create a bank account with the provided details
    }

    @When("I transfer €{int} from account {string} to account {string} in GBP")
    public void i_transfer_from_account_to_account_in_gbp(Integer amount, String fromAccount, String toAccount) {
        // Implement your transfer logic here
        // For example, you can transfer the specified amount from one account to another
    }

    @When("I transfer £{int} from account {string} to account {string} in USD")
    public void i_transfer_from_account_to_account_in_usd(Integer amount, String fromAccount, String toAccount) {
        // Implement your transfer logic here
        // For example, you can convert the amount to USD and then transfer it
    }

    @When("User with account number123456 transfers ${int}")
    public void user_with_account_number123456_transfers_$(Integer transferAmount) {
        // Implement your transfer logic here
        // For example, you can simulate a user transferring the specified amount
        System.out.println("User transfers $" + transferAmount);
        // Add your actual logic here
    }

    @When("User with account number123456 transfer ${int}")
    public void user_with_account_number123456_transfer_$(Integer transferAmount) {
        // Implement your transfer logic here
        // For example, you can simulate a user transferring the specified amount
        System.out.println("User transfers $" + transferAmount);
        // Add your actual logic here
    }

    @Then("Bank account {int} should have ${int} dollars in balance")
    public void bank_account_should_have_$_dollars_in_balance(Integer accountNumber, Integer expectedBalance) {
        // Implement your verification logic here
        // For example, you can check if the bank account with the given account number has the expected balance
        System.out.println("Verifying balance for account " + accountNumber + ": $" + expectedBalance);
        // Add your actual verification logic here
    }
}
