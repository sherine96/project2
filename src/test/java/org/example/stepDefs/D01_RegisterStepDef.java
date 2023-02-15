package org.example.stepDefs;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Hook;
import org.example.pages.P01_Register;
import io.cucumber.java.en.Given;
import org.example.pages.P02_Login;
import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class D01_RegisterStepDef {

    P01_Register register = new P01_Register();

    //ConfigReader reader = new ConfigReader();


    @Given("user go to register page")
    public void goRegisterPage() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(register.rbtn));
        register.rbtn.click();
        //Hooks.driver.navigate().to("https://demo.nopcommerce.com/register?returnUrl=%2F");
        //Hooks.driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
       // Thread.sleep(100);
        //Hooks.driver.findElement(By.cssSelector("a[href=\"/register?returnUrl=%2F\"]")).click();
    }


    //P01_Register register = new P01_Register();
    @When("user select gender type")
    public void userSelectGenderType() {
        register.male.click();
    }

    @And("user enter first name {string} and last name {string}")
    public void userEnterFirstNameAndLastName(String arg0, String arg1) {
        register.firstName.sendKeys(arg0);
        register.lastName.sendKeys(arg1);
    }

    @And("user enter date of birth")
    public void userEnterDateOfBirth() {
        //Select Day
        Select selectDay = new Select(register.dayList);
        selectDay.selectByValue("6");

        //Select Month
        Select selectMonth = new Select(register.monthList);
        selectMonth.selectByVisibleText("March");
        //   selectMonth.selectByValue("3");

        //Select Year
        Select selectYear = new Select(register.yearList);
        selectYear.selectByIndex(9);

    }

    @And("user enter email {string} field")
    public void userEnterEmailField(String arg0) {
        //Faker fake = new Faker();
       // String emailAddress = fake.internet().safeEmailAddress();
       // System.out.println(emailAddress);
        //reader.set("email",emailAddress);
        register.Email.sendKeys(arg0);
    }

    @And("user fills Password fields {string} {string}")
    public void userFillsPasswordFields(String arg0, String arg1) {
        register.password.sendKeys(arg0);
        register.ConfirmPassword.sendKeys(arg1);
    }

    @And("user clicks on register button")
    public void userClicksOnRegisterButton() {
        register.registerBtn.click();
    }

    @Then("success message is displayed")
    public void successMessageIsDisplayed() {
        SoftAssert soft = new SoftAssert();

        //1- get text and verify it contains "your registration completed"
        soft.assertTrue(register.successMsg.getText().toLowerCase().contains("registration completed"));

        //2- get css value and verify color is green #4cb17c  hex
        String actualColor = register.successMsg.getCssValue("color");
        soft.assertEquals(actualColor, "rgba(76, 177, 124, 1)");

        soft.assertAll();
    }

}

