package org.example.stepDefs;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import org.example.pages.P02_Login;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import java.time.Duration;


public class D02_loginStepDef {
    P02_Login login = new P02_Login();
    @Given("user go to login page")
    public void user_go_to_login_page()  throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(login.logbtn));
       login.logbtn.click();

    }

    @When("user login with {string} {string} and {string}")
    public void user_login_with_and(String string, String string2, String string3) {
        login.email.sendKeys(string2);
        login.password.sendKeys(string3);

    }
    @When("user press on login button")
    public void user_press_on_login_button() {
        login.loginbtn.click();

    }
    @Then("user could not login to the system")
    public void user_could_not_login_to_the_system() {
        SoftAssert soft=new SoftAssert();
        soft.assertTrue(login.errMsg.getText().toLowerCase().contains("login was unsuccessful"));
        String color=login.errMsg.getCssValue("color");
        color= Color.fromString(color).asHex();
        soft.assertEquals(color,"#e4434b");
        soft.assertAll();
    }
    @Then("user login to the system successfully")
    public void user_login_to_the_system_successfully() {
        SoftAssert soft=new SoftAssert();
        String url= Hooks.driver.getCurrentUrl();
        soft.assertEquals(url,"https://demo.nopcommerce.com/");
        soft.assertTrue(login.account.isDisplayed());
        soft.assertAll();
    }



}