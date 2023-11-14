package steps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TransferSteps {
    @Given("User with account number {int} is registered")
    public void user_with_account_number_is_registered(Integer int1) {
        System.out.println("My First Given Step. What a ride with wedvex!!!");
    }

    @Given("User with account number {int} deposited ${double}")
    public void user_with_account_number_deposited_$(Integer accountNumber, double Deposit) {
        System.out.println("The Account number for " + accountNumber);
        System.out.println("The amount of the deposit it $" + Deposit);
    }

    @When("User with account number {int} transfer ${double}")
    public void user_with_account_number_transfer$(Integer accountNumber, double transferAmount) {
        System.out.println("This is When we show the account number "+ accountNumber);
        System.out.println("The transfer amount is $"+transferAmount);
    }
    @Then("User with account number {int} should have ${double} in balance")
    public void user_with_account_number_should_have_$_in_balance(Integer accountNumber, Double balanceAmount) {
        System.out.println("This is the Account number "+ accountNumber );
        System.out.println("The amount in this Checking Account is $" + balanceAmount);
    }
    @Then("User should see Insufficient Funds message")
    public void user_should_see_insufficient_funds_message() {
        System.out.println("this is d");
    }

    @Given("User is on {string}")
    public void user_is_on_qa_chase_com(String envURL) {
        System.out.println("Get to " + envURL);
    }


}
