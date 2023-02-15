package org.example.stepDefs;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_Register;
import org.example.pages.P03_homePage;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class D03_currenciesStepDef {
    P03_homePage h = new P03_homePage();
    @When("user changes currency to euro")
    public void user_changes_currency_to_euro() {
        Select selectc = new Select(h.currency);
        selectc.selectByVisibleText("Euro");}

    @Then("user sees the new currency")
    public void user_sees_the_new_currency() {
        boolean ceuro=true;
        String[] price = new String[4];
        for(int i=0;i<4;i++){
            price[i]=h.prices().get(i).getText();
            Assert.assertTrue(price[i].contains("€"));
        }
    }

}
