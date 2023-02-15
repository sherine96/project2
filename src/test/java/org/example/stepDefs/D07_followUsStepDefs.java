package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Hook;
import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Set;

public class D07_followUsStepDefs {
    String homehandle="";
    String opened="";

    P03_homePage h = new P03_homePage();
    @When("user opens facebook link")
    public void user_opens_facebook_link() {
        homehandle=Hooks.driver.getWindowHandle();
        h.facebook.click();
    }
    @Then("{string} is opened in new tab")
    public void is_opened_in_new_tab(String string) {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(7));
        opened=Hooks.driver.getWindowHandle();
        Set<String> ghandle=Hooks.driver.getWindowHandles();
        String[] handles=ghandle.toArray(new String[2]);
        Hooks.driver.switchTo().window(handles[1]);
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),string);


    }

    @When("user opens twitter link")
    public void user_opens_twitter_link() {
        homehandle=Hooks.driver.getWindowHandle();
        h.twitter.click();
    }
    @When("user opens rss link")
    public void user_opens_rss_link() {
        homehandle=Hooks.driver.getWindowHandle();
        h.rss.click();
    }
    @When("user opens youtube link")
    public void user_opens_youtube_link() {
        homehandle=Hooks.driver.getWindowHandle();
       h.youtube.click();
    }
}
