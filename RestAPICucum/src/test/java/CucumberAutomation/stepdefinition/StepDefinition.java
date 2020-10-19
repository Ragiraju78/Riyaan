package CucumberAutomation.stepdefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class StepDefinition {
    @Given("^User is on the netbank login page$")
    public void user_is_on_the_netbank_login_page() throws Throwable {
        System.out.println("Given Method");
        throw new PendingException();
    }
    @When("^User logs in to the app by providing user name and password$")
    public void user_logs_in_to_the_app_by_providing_user_name_and_password()throws Throwable  {
        System.out.println("When method");
        throw new PendingException();
    }
    @Then("^Home page is populated$")
    public void home_page_is_populated() throws Throwable  {
        System.out.println("Then method");
        throw new PendingException();
    }
    @Then("^User details and account details displayed$")
    public void user_details_and_account_details_displayed()throws Throwable   {
        System.out.println("And method");
        throw new PendingException();
    }

}