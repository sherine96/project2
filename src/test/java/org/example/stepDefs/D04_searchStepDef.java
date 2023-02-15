package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class D04_searchStepDef {
    P03_homePage h = new P03_homePage();
    @When("User enters product name as {string}")
    public void user_enters_product_name_as(String string) throws InterruptedException {
        h.search.sendKeys(string);

    }
    @When("User pressess enter")
    public void user_pressess_enter() {
        h.search.sendKeys(Keys.ENTER);

    }
    @Then("make sure search contains search word as {string}")
    public void make_sure_search_is_done(String string) {
        SoftAssert soft=new SoftAssert();
        int r=h.results().size();
        String url=Hooks.driver.getCurrentUrl();
        soft.assertTrue(url.contains("https://demo.nopcommerce.com/search?q="));
        for(int i=0;i<r;i++){
            WebElement productdes=h.results().get(i).findElement(By.xpath("./child::*"));
            soft.assertTrue(productdes.getText().toLowerCase().contains(string));
        }
        soft.assertAll();
    }

    @When("User enters sku as {string}")
    public void userEntersSkuAs(String arg0) {
        h.search.sendKeys(arg0+Keys.ENTER);
    }

    @When("Press product link")
    public void pressProductLink() {
        WebElement productdes=h.results().get(0).findElement(By.xpath("./child::*"));
        productdes.click();
    }

    @Then("Make sure entered sku as {string} is the same as in page.")
    public void makeSureEnteredSkuAsIsTheSameAsInPage(String arg0) {
        WebElement e1=Hooks.driver.findElement(By.className("sku"));
        WebElement e2=e1.findElement(By.className("value"));
        String sku=e2.getText();
        SoftAssert soft=new SoftAssert();
        soft.assertEquals(sku,arg0);
        soft.assertAll();
    }
}
