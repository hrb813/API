package StepDefinitions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static assertiontests.ResponseAssertions.responseResult;
import static utility.APIUtility.*;


public class RefStepdefs {



    @Given("the use connects to the API for English entries")
    public void theUseConnectsToTheAPIForEnglishEntries() {
        targetEnglish();

    }




//    @When("the user enters the word id <Word>")
//    public void theUserEntersTheWordIdWord(String arg0) {
//        xvalue = arg0;
//
//    }

    @When("the user enters the word id {string}")
    public void theUserEntersTheWordId(String arg0) {
        xvalue = arg0;
    }



    @Then("the response returned is {string}")
    public void theResponseReturnedIs(String arg0) {
        responseResult(getStatus(),arg0);

    }
}
