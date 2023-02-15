package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class D08_WishlistStepDef {
    P03_homePage h = new P03_homePage();
    SoftAssert soft=new SoftAssert();

    @When("click on wishlist button on this product {string}")
    public void lick_on_wishlist_button_on_this_product(String string) {
        h.wishbtn.click();
    }
    @Then("success message is displayed after wish")
    public void success_message_is_displayed_after_wish() {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.visibilityOf(h.msg));
        String msg=h.msg.getText();
        soft.assertTrue(msg.contains("The product has been added to your "));
        soft.assertAll();
        //By.cssSelector("div[id=\"bar-notification\"]")
    }
    @Then("background color is green")
    public void background_color_is_green() {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(7));
        String color=h.bar.getCssValue("background-color");
        color= Color.fromString(color).asHex();
        soft.assertEquals(color,"#4bb07a");
        soft.assertAll();
    }
    @When("wait for msg to disappear")
    public void waitForMsgToDisappear() {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.invisibilityOf(h.bar));
    }
    @When("click on wishlist")
    public void clickOnWishlist() {
        h.wishlistbtn.click();
    }
    @Then("check quantity")
    public void checkQuantity() {
        String q=h.qty.getAttribute("value");
        int quan=Integer.parseInt(q);
        soft.assertTrue(quan>0);
        soft.assertAll();
    }


}
