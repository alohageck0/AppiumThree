package CucumberTesting;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EmployeeTests {

   @Given("^I work in ([^\"]*)$")
   public void iWork(String string) {
      if (string.equals("late nights")) {
         System.out.println("Late night automation\n");
      }
      if (string.equals("the mornings")) {
         System.out.println("Mornings automation");
      }
   }

   @When("^I meet ([^\"]*)$")
   public void iMeet(String string) {
      if (string.equals("watchman")) {
         System.out.println("watchman automation");
      }
      if (string.equals("newspaper boy")) {
         System.out.println("newspaper boy automation");
      }
   }

   @Then("^I ([^\"]*) him$")
   public void action(String string) {
      if (string.equals("greet")) {
         System.out.println("greeted");
      }
      if (string.equals("skip greet")) {
         System.out.println("greetings skipped");
      }
   }
}
