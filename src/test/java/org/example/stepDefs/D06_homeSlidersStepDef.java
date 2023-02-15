package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class D06_homeSlidersStepDef {
    P03_homePage h = new P03_homePage();

    @Given("wait until banner 1 is displayed")
    public void wait_until_banner_is_displayed() {
        WebDriverWait wait=new WebDriverWait(Hooks.driver, Duration.ofSeconds(8));
        wait.until(ExpectedConditions.attributeToBe(h.sliderImg,"src","https://demo.nopcommerce.com/images/thumbs/0000089_banner_02.webp"));
    }

    @Then("check if url is nokia link")
    public void check_if_url_is_https_demo_nopcommerce_com_nokia_lumia() throws InterruptedException {
        Thread.sleep(2000);
        String url=Hooks.driver.getCurrentUrl();
        String expexc="https://demo.nopcommerce.com/nokia-lumia-1020";
        Assert.assertEquals(url,expexc);
    }

    @Given("wait until banner 2 is displayed")
    public void wait_until_banner2_is_displayed() {
        WebDriverWait wait=new WebDriverWait(Hooks.driver, Duration.ofSeconds(8));
        wait.until(ExpectedConditions.attributeToBe(h.sliderImg,"src","https://demo.nopcommerce.com/images/thumbs/0000088_banner_01.webp"));

    }
    @When("click on 2nd slider")
    public void click_on_slider() {

        h.slider2.click();
    }
    @Then("check if url is iphone link")
    public void check_if_url_is_https_demo_nopcommerce_com_iphone() throws InterruptedException {
        Thread.sleep(2000);
        String url=Hooks.driver.getCurrentUrl();
        String expexc="https://demo.nopcommerce.com/iphone-6";
        Assert.assertEquals(url,expexc);
    }


    @When("click on 1st slider")
    public void clickOnStSlider() {
        h.slider1.click();
    }
}
